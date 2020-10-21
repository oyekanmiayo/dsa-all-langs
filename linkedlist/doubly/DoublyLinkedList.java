/**
 * @author Ayomide Oyekanmi
 */
class DoublyLinkedList<E> {
    /** 
     * This represents the template for the node object that is used in the linkedlist
     */
    class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element){
            this.element = element;
            prev = null;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList(){ 
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add element to front of the list, so that it becomes new head node
     * 
     * @param element element that the new node created wraps around
     */
    public void addFirst(E element){
         // Create new node to wrap element
         Node<E> newHead = new Node(element);
         // Set the new node's next pointer to the current head
         newHead.next = head;

         // Set the current head's previous pointer to new node, if current head exists
         if (head != null){
             head.prev = newHead;
         }

         // Set new node as head
         head = newHead;
 
         // If tail hasn't be set, tail is equal to head
         if(tail == null){
             tail = head;
         }
 
         // Increment size
         size++;
    }

    /**
     * Add element to back of the list, so that it becomes new tail node
     * 
     * @param element element that the new node created wraps around
     */
    public void addLast(E element){
        if(tail == null){
            addFirst(element);
            return;
        }

        // Create new node to wrap element
        Node<E> newTail = new Node(element);

        // Set the current tail node's next pointer to the new node
        tail.next = newTail;

        // Set the new node's previous pointer to current tail node
        newTail.prev = tail;

        // Set new node as tail
        tail = newTail;
    }

    /**
     * At element at any position in the list
     * 
     * @param n represents position to insert element into.
     * @param element represents element to be inserted into position n
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public void addAtPosition(int n, E element){}

    /**
     * Removes head of the list and returns it
     * 
     * @return returns removed element
     * @throws NoSuchElementException if list has no head i.e. the list is empty
     */
    public E removeFirst(){}

    /**
     * Removes tail of the list and returns it
     * 
     * @return returns removed element
     * @throws NoSuchElementException if list has no tail i.e. the list is empty
     */
    public E removeLast(){}

    /**
     * Removes element at position n in the list and returns it
     * 
     * @param n position to remove element from
     * @return returns removed element
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public E removeAtPosition(int n){}
}