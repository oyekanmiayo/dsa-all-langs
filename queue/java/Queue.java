import java.util.NoSuchElementException;

/**
 * @author Ayomide Oyekanmi
 * @notes This implementation uses a Doubly Linked List as the underlying
 *          data structure
 */
class Queue<E> {

    // check linkedlist/doubly/java/DoublyLinkedList.java for implementation
    DoublyLinkedList<E> linkedList;

    public Queue(){
        linkedList = new DoublyLinkedList();
    }

    /**
     * Add element to back of the queue
     * 
     * @param element element to be added to the back of the queue
     */
    public void enqueue(E element){
        linkedList.addLast(element);
    }

    /**
     * Removes element at the front of the queue
     * 
     * @return returns removed element
     * @throws NoSuchElementException if queue is empty
     */
    public E dequeue()throws NoSuchElementException {
        return linkedList.removeFirst();
    }

    /**
     * Retrieves element at the front of the queue
     * 
     * @return returns retrieved element
     * @throws NoSuchElementException if queue is empty
     */
    public E peek()throws NoSuchElementException{
        return linkedList.peek();
    }
}