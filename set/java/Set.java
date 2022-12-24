/**
 * @author: Ayomide Oyekanmi
 */
class Set<E> {
     /** 
     * This represents the template for the object that is stored at the underlying array's indexes
     */
    class Entry<E>{
        E element;
        Entry<E> next;

        public Entry(E element){
            this.element = element;
        }
    }

    // Prime used to increase chances of generating unique keys
    private final int PRIME = 31;
    private Entry<E>[] entries;

    public Set(){
        // Prime used to increase chances of unique remainders, leading to better distribution
        entries = new Entry[29]; 
    }

    /**
     * Stores the element in the set.
     * 
     * @param element element to be stored in the set
     * @return true if element to be added doesn't exist, and false if it does
     */
    public boolean add(E element){
        // Generate hash (or index)
        int hash = getHashForElement(element);

        //Store element, if there's no collision
        if(entries[hash] == null) {
            entries[hash] = new Entry<>(element);
            return true;
        } 

        // If there's a collision, insert entry at tail of bucket (linkedlist)
        Entry entry = entries[hash];
        while(entry.next != null){
            entry = entry.next;

            // If element exists already, return because we don't want duplicates
            if(element.equals(entry.element)){
                return false;
            }
        }
       
        entry.next = new Entry<>(element);
        return true;
    }

    /**
     * Checks if the element is in the set.
     * 
     * @param element element whose presence is to be checked in the set
     * @return true if element exists, and false if it doesn't
     */
    public boolean contains(E element){
        // Generate hash (or index)
        int hash = getHashForElement(element);

        // If no element is stored at index, then return false
        if(entries[hash] == null) {
            return false;
        } 

        // If there's a collision, traverse bucket(linkedlist) to find
        // out if the element exists
        Entry entry = entries[hash];
        while(entry != null){

            // If element is found, return true
            if(element.equals(entry.element)){
                return true;
            }

            entry = entry.next;
        }
       
        // If element is not found, return false
        return false;
    }

    /**
     * @return a list of all elements in the set
     */
    public List<E> list(){
        // Use Java in-built list
        List<E> entryList = new ArrayList<>();

        // Traverse every index in array
        for(int i = 0; i < entries.length; i++){
            Entry entry = entries[i];
            
            // Traverse bucket at each index
            while(entry != null){
                entryList.add(entry);
                entry = entry.next;
            }
        }

        return entryList;
    }

    public boolean remove(E element){
        // Generate hash
        int hash = getHashForElement(element);

        Entry entry = entries[hash];

        //If element is at the head, set head to next entry
        if (element.equals(entry.element)){
            entries[hash] = entry.next;
        }

        // This will never be null when it is called because we already know
        // that the first entry is not the one we want
        Entry prev = null;

        while(entry != null){

            // return true if element exists and was deleted
            if (element.equals(entry.element)){
                prev.next = entry.next;
                return true;
            } 

            prev = entry;
            entry = entry.next;
        }

        // If element doesn't exist, so was not deleted 
        return false;
    }

    private int getHashForElement(E element){
        return (element.hashCode() * PRIME) % entries.length;
    }
}