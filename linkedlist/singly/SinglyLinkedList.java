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
    private int size;

    public SinglyLinkedList(){ 
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
        // Set the new node's pointer to the current head
        newHead.next = head;
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
        // Starting at head node, traverse the linkedlist until tail node is reached
        Node<E> node = head;
        while(node.next != null){
           node = node.next; 
        }

        // Set the current tail node's pointer to the new node that wraps around element
        node.next = new Node(element);
        // Set new node as new tail node
        tail = node.next;

        // Increment size
        size++;
    }

    /**
     * At element at any position in the list
     * 
     * @param n represents position to insert element into.
     * @param element represents element to be inserted into position n
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public void addAtPosition(int n, E element){
        if (n > size){
            IllegalArgumentException("No such position");
        }

        if (n == 1){
            addFirst(element);
            return;
        }

        int index = 1;
        Node<E> prev = null;
        Node<E> node = head;
        Node<E> newNode = new Node(element);

        // node != null check is not necessary because we already check if given index is valid
        // using if (n > size - 1) 
        while(index <= n && node != null){
            if(index == n){
                break;
            }

            prev = node;
            node = node.next;
        }

        prev.next =  newNode;
        newNode.next = node;

        // Increment size
        size++;
    }

    /**
     * Removes head of the list and returns it
     * 
     * @return returns removed element
     * @throws NoSuchElementException if list has no head i.e. the list is empty
     */
    public E removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }

        if(head.next == null){
            head = null;
            tail = null;
            return;
        }

        Node<E> nodeToRemove = head;
        head = head.next;

        size--;
        return nodeToRemove;
    }

    /**
     * Removes tail of the list and returns it
     * 
     * @return returns removed element
     * @throws NoSuchElementException if list has no tail i.e. the list is empty
     */
    public E removeLast(){
        if (tail == null){
            throw new NoSuchElementException();
        }

        if(head.next == null){
            head = null;
            tail = null;
            return;
        }

        Node<E> prev = null;
        Node<E> node = head;
        while(node.next != null){
            prev = node;
            node = node.next;
        }

        prev.next = null;
        tail = prev;

        size--;
        return node;
    }

    /**
     * Removes element at position n in the list and returns it
     * 
     * @param n position to remove element from
     * @return returns removed element
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public E removeAtPosition(int n){
        if (n > size){
            IllegalArgumentException("No such position");
        }

        if(n == 0){
            removeFirst();
            return;
        }

        if(n == size){
            removeLast();
            return;
        }

        int index = 0;
        Node<E> prev = null;
        Node<E> node = head;

        while(index <= n && node != null){
            prev = node;
            node = node.next;
        }

        prev.next = node.next;

        size--;
        return node;
    }
}