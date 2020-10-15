/**
 * @author: Ayomide Oyekanmi
 */
class Map<K, V> {

    /** 
     * This represents the template for the object that is stored at memory addresses
     */
    class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    // Prime used to increase chances of generating unique keys
    private final int PRIME = 31;
    private Entry<K, V>[] entries;

    public Map(){
        // Prime used to increase chances of unique remainders, leading to better distribution
        entries = new Entry[29]; 
    }

    /**
     * Stores the mapping between K key and V value. 
     * 
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void put(K key, V value){
        // Generate hash
        int hash = getHashForKey(key);

        //Store value, if there's no collision
        if(entries[hash] == null) {
            entries[hash] = new Entry<>();
            return;
        } 

        // If there's a collision, insert entry at tail of bucket (linkedlist)
        Entry entry = entries[hash];
        while(entry.next != null){
            entry = entry.next;

            // If key exists already, just update its associated value
            if(key.equals(entry.key)){
                entry.value = value;
                return;
            }
        }
       
        entry.next = new Entry<>(key, value);
    }

    /**
     * Returns the value to which the specified K key is mapped.
     * 
     * @param key key whose associated value is to be returned
     * @return returns the associated value or null if the key does not exist
     */
    public V get(K key){
        // Generate hash
        int hash = getHashForKey(key);

        Entry entry = entries[hash];
        while(entry != null){
            // If key is found, return the value
            if(key.equals(entry.key)){
                return entry.value;
            }

            entry = entry.next;
        }

        // If this point is reached, it means this key does not exist in the map
        return null;
    }

    /**
     * Deletes the value to which the specified K key is mapped.
     * Remember that this is a LinkedList, so there are a few edgecases to handle
     * 
     * @param key key whose associated value is to be deleted
     */
    public void delete(K key){
        // Generate hash
        int hash = getHashForKey(key);

        Entry entry = entries[hash];

        //If key is at the head, set head to next entry
        if (key.equals(entry.key)){
            entries[hash] = entry.next;
        }

        // This will never be null when it is called because we already know
        // that the first entry is not the one we want
        Entry prev = null;

        while(entry != null){
            if (key.equals(entry.key)){
                prev.next = entry.next;
                return;
            } 

            prev = entry;
            entry = entry.next;
        }
    }

    private int getHashForKey(K key){
        // Non-standard hash algorithm ;)
        return (key.hashCode() * PRIME) % entries.length;
    }
}

/**
 * The Map object will be instantiated and called as such:
 * Map<Integer, String> obj = new Map<>();
 * obj.put(1, 'Ayo');
 * System.out.println(obj.get(1)) # Ayo
 * obj.delete(1);
 * System.out.println(obj.get(1)) # null
 */