/**
 * @author Ayomide Oyekanmi
 */
class SinglyLinkedList<E> {

    /** 
     * This represents the template for the node object that is used in the linkedlist
     */
    class Node<E> {
        E element;
        Node<E> next;

        public Node(E element){
            this.element = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public SinglyLinkedList(){ 
        head = null;
        tail = null;
    }

    /**
     * Add element to front of the list, so that it becomes new head node
     * 
     * @param element element that the new node created wraps around
     */
    public void addFirst(E element){
        // Create new node to wrap element
        Node<E> newHead = new Node(element);
        // Set the new node's pointer to the current head
        newHead.next = head;
        // Set new node as head
        head = newHead;

        // If tail hasn't be set, tail is equal to head
        if(tail == null){
            tail = head;
        }
    }

    /**
     * Add element to back of the list, so that it becomes new tail node
     * 
     * @param element element that the new node created wraps around
     */
    public void addLast(E element){
        // Starting at head node, traverse the linkedlist until tail node is reached
        Node<E> node = head;
        while(node.next != null){
           node = node.next; 
        }

        // Set the current tail node's pointer to the new node that wraps around element
        node.next = new Node(element);
        // Set new node as new tail node
        tail = node.next;
    }

    public void addAtPosition(int n, E element){

    }

    public E removeFirst(){

    }

    public E removeLast(){

    }

    public E removeAtPosition(int n){

    }
}