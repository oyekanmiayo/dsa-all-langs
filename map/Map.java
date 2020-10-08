class Map<K, V> {
    Entry[] mapArray;

    public void put(K key, V value){

    }

    public V get(K key){

    }

    public void delete(K key){

    }

    /** This represents the object that is stored at memory addresses*/
    class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;
    }
}