/**
 * @author: Inioluwa Akinleye
 */

#include <iostream>
#include <vector>

using namespace std;

template <typename K, typename V>
class Map {

    // This represents the template for the object that is stored at the underlying array's indexes
    struct Entry {
        K key;
        V value;
        Entry* next;

        // Entry (K k, V v) : key(k), value(v), next(nullptr) {}
        Entry(K k, V v) {
            key = k;
            value = v;
            next = nullptr;
        }
    };
private:
    // Prime used to increase chances of generating unique keys
    const int PRIME = 31;
    vector<Entry*> entries;
public:
    Map() {
        // Prime used to increase chances of unique remainders, leading to better distribution
        entries = vector<Entry*>(29);
    }

    /**
     * Stores the mapping between K key and V value.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    void put (K key, V value) {
        // Generate hash
        int hash = getHashForKey(key);

        //Store value, if there's no collision
        if (!entries[hash]) {
            entries[hash] = new Entry(key, value);
            return;
        }

        // If there's a collision, insert entry at tail of bucket (linkedlist)
        Entry* entry = entries[hash];
        while (entry->next != nullptr) {
            entry = entry->next;

            // If key exists already, just update its associated value
            if (key == entry->key) {
                entry->value = value;
                return;
            }
        }
        entry->next = new Entry(key, value);
    }

    /**
     * Returns the value to which the specified K key is mapped.
     *
     * @param key key whose associated value is to be returned
     * @return returns the associated value or null if the key does not exist
     */
    V get (K key) {
        // Generate hash
        int hash = getHashForKey(key);

        Entry* entry = entries[hash];
        while (entry != nullptr) {
            // If key is found, return the value
            if (key == entry->key) {
                return entry->value;
            }
            entry = entry->next;
        }
        // If this point is reached, it means this key does not exist in the map
        return 0;
    }

    /**
     * Deletes the value to which the specified K key is mapped.
     * Remember that this is a LinkedList, so there are a few edgecases to handle
     *
     * @param key key whose associated value is to be deleted
     */
    void remove (K key) {
        // Generate hash
        int hash = getHashForKey(key);

        Entry* entry = entries[hash];

        //If key is at the head, set head to next entry
        if (key == entry->key) {
            entries[hash] = entry->next;
            return;
        }

        // This will never be null when it is called because we already know
        // that the first entry is not the one we want
        Entry* prev = nullptr;

        while (entry != nullptr) {
            if (key == entry->key) {
                prev->next = entry->next;
                return;
            }

            prev = entry;
            entry = entry->next;
        }
    }
private:
    int getHashForKey(K key) {
        // Non-standard hash algorithm -- See Ayo, LOL ;)
        hash<int> hash_fn;
        return (hash_fn(key) * PRIME) % entries.size();
    }
};

/*int main() {
    Map<int, int> map;
    map.put(1, 3);
    map.put(2, 5);
    map.put(3, 6);
    cout << map.get(1) << endl;
    cout << map.get(2) << endl;
    // map.remove(2);
    map.remove(3);
    cout << map.get(2);
}*/
