/**
 * @author: Ayomide Oyekanmi
 * @notes: This implementation uses an **ARRAY** as the underlying data structure
 */
class ArrayStack<E> {
    private int top;
    private E[] entries;

    ArrayStack(){
        // Using a random initial size of 16
        entries = new E[16];
        top = -1;
    }

    /**
     * This operation add the element to the top of the stack
     * 
     * @param element element to be added to stack
     */
    public void push(E element){
        if(top + 1 == entries.length){
            createBiggerArray();
        }
        
        entries[++top] = element;
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

        // Point `entries` variable to now reference new array
        entries = entriesTwo;
    }

    /**
     * Removes and returns the element at the top of the stack, if it exists
     */
    public E pop(){
        // Checks if stack is empty
        if(top == -1){
            throw new EmptyStackException();
        }

        return entries[top--];
    }

    /**
     * Returns the element at the top of the stack, if it exists
     * This operation does not remove any element
     */
    public E peek(){
        if(top == -1){
            throw new EmptyStackException();
        }

        return entries[top];
    }

}