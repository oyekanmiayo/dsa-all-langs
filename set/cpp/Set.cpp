/**
 * @author: Inioluwa Akinleye
 */

#include <iostream>
#include <vector>

using namespace std;

template <typename E>
class Set {

    // This represents the template for the object that is stored at the underlying array's indexes
    struct Entry {
        E element;
        Entry* next;

        // Entry (E e) : element(e), next(nullptr) {}
        explicit Entry(E e) {
            element = e;
            next = nullptr;
        }
    };
private:
    // Prime used to increase chances of generating unique keys
    const int PRIME = 31;
    vector<Entry*> entries;
public:
    Set() {
        // Prime used to increase chances of unique remainders, leading to better distribution
        entries = vector<Entry*>(29);
    }

    /**
     * Stores the element in the set.
     *
     * @param element element to be stored in the set
     * @return true if element to be added doesn't exist, and false if it does
     */
    bool add (E element) {
        // Generate hash
        int hash = getHashForElement(element);

        //Store element, if there's no collision
        if (!entries[hash]) {
            entries[hash] = new Entry(element);
            return true;
        }

        // If there's a collision, insert entry at tail of bucket (linkedlist)
        Entry* entry = entries[hash];
        while (entry->next != nullptr) {
            entry = entry->next;

            // If element exists already, return because we don't want duplicates
            if (element == entry->element) {
                return false;
            }
        }
        entry->next = new Entry(element);
        return true;
    }

    /**
     * Checks if the element is in the set.
     *
     * @param element element whose presence is to be checked in the set
     * @return true if element exists, and false if it doesn't
     */
    bool contains (E element) {
        // Generate hash
        int hash = getHashForElement(element);

        // If no element is stored at index, then return false
        if (!entries[hash]) {
            return false;
        }

        // If there's a collision, traverse bucket(linkedlist) to find
        // out if the element exists
        Entry* entry = entries[hash];
        while (entry != nullptr) {

            // If element is found, return true
            if (element == entry->element) {
                return true;
            }
            entry = entry->next;
        }
        return false;
    }

    /**
     * @return a list of all elements in the set
     */
    vector<E> list() {
        vector<E> entryList;

        // Traverse every index in array
        for (auto entry : entries) {
            // Traverse every index in array
            while (entry) {
                entryList.push_back(entry);
                entry = entry->next;
            }
        }
        return entryList;
    }

    /**
     * Removes an element from the set.
     *
     * @param element element to be removed from the set
     * @return true if element exists and was deleted, and false if it doesn't, thereby no deletion
     */
    bool remove (E element) {
        // Generate hash
        int hash = getHashForElement(element);

        Entry* entry = entries[hash];

        //If element is at the head, set head to next entry
        if (element == entry->element) {
            entries[hash] = entry->next;
            return true;
        }

        // This will never be null when it is called because we already know
        // that the first entry is not the one we want
        Entry* prev = nullptr;

        while (entry != nullptr) {

            // return true if element exists and was deleted
            if (element == entry->element) {
                prev->next = entry->next;
                return true;
            }

            prev = entry;
            entry = entry->next;
        }

        // If element doesn't exist, so was not deleted
        return false;
    }
private:
    int getHashForElement(E element) {
        // Non-standard hash algorithm -- See Ayo, LOL ;)
        hash<int> hash_fn;
        return (hash_fn(element) * PRIME) % entries.size();
    }
};

/*int main() {
    Set<int> set;
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);

    cout << set.contains(1) << endl;
    cout << set.contains(2) << endl;

    set.remove(2);
    set.remove(3);
    cout << set.contains(3);
}*/
