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

    public void addAtPosition(int n, E element){
        if (n > (size - 1)){
            IllegalArgumentException("No such position");
        }

        if (n == 0){
            addFirst(element);
            return;
        }

        int index = 0;
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

    public E removeAtPosition(int n){
        if (n > (size - 1)){
            IllegalArgumentException("No such position");
        }

        if(n == 0){
            removeFirst();
            return;
        }

        if(n == size - 1){
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