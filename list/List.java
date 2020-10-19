class List<E> {
    E[] entries;
    // This variable keeps track of the next free index
    int currIdx = 0;

    List(){
        // Using a random initial size of 16
        entries = new E[16];
    }

    /**
     * Adds element to back of list
     * 
     * @param element element to be added to list
     */
    public void add(E element){
        // If current array is filled, create a new array 
        // that is double the size of the old one
        if (currIdx == entries.length()){
            createBiggerArray();
        }

        // insert element at the next available index
        entries[currIdx] = element;
        // increment to next available index
        currIdx++;
    }

    /**
     * Adds element at specific index
     * 
     * @param n index to insert element at
     * @param element element to be added to list
     */
    public void add(int n, E element){
        // If current array is filled, create a new array 
        // that is double the size of the old one
        if (currIdx == entries.length()){
            createBiggerArray();
        }

        // Moves all elements from index n to currIdx - 1 forward by one index
        // At the end of this, index n will be `free` :)
        int movingIdx = currIdx;
        while (movingIdx > n){
            entries[movingIdx] = entries[movingIdx - 1];
            movingIdx--;
        }

        // Insert element into `free` index n
        entries[n] = element;
        // increment to next available index
        currIdx++;
    }

    /**
     * Use to create a new array that is double the size of the old one
     */
    private void createBiggerArray(){
        int newSize = entries.length * 2;
        E[] entriesTwo = new E[newSize];
        
        // Using a manual method to copy array here to ensure an in-depth understanding
        // Java has inbuilt methods that abstract this e.g. System.arrayCopy()
        for(int i = 0; i < entries.length; i++){
            entriesTwo[i] = entries[i];
        }

        // point `entries` variable to now reference new array
        entries = entriesTwo;
    }

    /**
     * Removes element at given index
     * 
     * @param n index from which to remove element
     * @return returns removed element
     */
    public E remove(int n){
        if(n >= entries.length){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d" start, len));
        }

        E element = entries[n];
        entries[n] = null;

        int movingIdx = n;
        while(movingIdx < currIdx - 1){
            entries[movingIdx] = entries[movingIdx + 1];
            movingIdx++;
        }

        currIdx--;
        return element;
    }

    /**
     * Retrieves element at given index
     * 
     * @param n index from which to retrieve element
     * @return returns retrieved element
     */
    public E get(int n){
        if(n >= entries.length){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d" start, len));
        }
        return entries[n];
    }

     /**
     * Sorts element in List in ascending order
     */
    public void sort(){
        Collections.sort(self);
    }

    /**
     * Returns all elements between start & end in a sublist
     * 
     * @param start index from which slice starts (inclusive)
     * @param end index to which slice ends (inclusive)
     * @return returns sublist containing slice
     */
    public List<E> slice(int start, int end){
        int len = entries.length
        if(start >= len){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d" start, len));
        }

        if(end >= len){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d" end, len));
        }

        List<E> slicedList = new List();
        for(int i = start; i <= end; i++){
            slicedList.add(entries[i]);
        }

        return slicedList;
    }

    /**
     * Reverses all elements in the list
     */
    public void reverse(){
        int start = 0;
        int end = currIdx - 1;
        while(start < end){
            E temp = entries[start];
            entries[start] = entries[end];
            entries[end] = temp;
            start++;
            end--;
        }
    }
}