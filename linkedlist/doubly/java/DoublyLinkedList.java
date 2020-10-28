import java.util.NoSuchElementException;

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

        public Node(E element) {
            this.element = element;
            prev = null;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> obj = new DoublyLinkedList<>();
        obj.addFirst(2);
        System.out.println(obj); // [2]
        obj.addLast(3);
        System.out.println(obj); // [2] <=> [3]
        obj.addAtPosition(2, 9);
        System.out.println(obj); // [2] <=> [9] <=> [3]
        System.out.println(obj.removeAtPosition(1)); // 2
        System.out.println(obj); // [9] <=> [3]
        System.out.println(obj.removeFirst()); // 9
        System.out.println(obj); // [3]
        System.out.println(obj.removeLast()); // 3
        System.out.println(obj); // Linkedlist is empty!
    }

    /**
     * Add element to front of the list, so that it becomes new head node
     *
     * @param element element that the new node created wraps around
     */
    public void addFirst(E element) {
        // Create new node to wrap element
        Node<E> newHead = new Node(element);
        // Set the new node's next pointer to the current head
        newHead.next = head;

        // Set the current head's previous pointer to new node, if current head exists
        if (head != null) {
            head.prev = newHead;
        }

        // Set new node as head
        head = newHead;

        // If tail hasn't be set, tail is equal to head
        if (tail == null) {
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
    public void addLast(E element) {
        if (tail == null) {
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

        // Increment size
        size++;
    }

    /**
     * At element at any position in the list
     *
     * @param n       represents position to insert element into.
     * @param element represents element to be inserted into position n
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public void addAtPosition(int n, E element) {
        // Checks if position exists
        if (n < 1 || n > size) {
            throw new IllegalArgumentException("No such position");
        }

        // Checks if element to be added will be the new head
        if (n == 1) {
            addFirst(element);
            return;
        }

        int index = 1;
        Node<E> node = head;
        Node<E> newNode = new Node(element);

        // Traverse till we get to position
        // PS: node != null check is not necessary because we already check if given index is valid
        // using if (n > size) 
        while (index != n) {
            node = node.next;
            index++;
        }

        Node<E> prev = node.prev;

        // Set the preceding node's next pointer to the new node
        prev.next = newNode;
        // Set new node's previous pointer to the preceding node
        newNode.prev = prev;
        // Set the new node's next pointer to the following node
        newNode.next = node;
        // Set the following node's previous pointer to the new node
        node.prev = newNode;

        // Increment size
        size++;
    }

    /**
     * Removes head of the list and returns it
     *
     * @return returns removed element
     * @throws NoSuchElementException if list has no head i.e. the list is empty
     */
    public E removeFirst() {
        // Checks if list is empty
        if (head == null) {
            throw new NoSuchElementException();
        }

        // Current head node
        Node<E> nodeToRemove = head;

        // Check if there's only one element in the list
        if (head.next == null) {
            head = null;
            tail = null;
            size = 0;
            return nodeToRemove.element;
        }

        Node<E> newHead = head.next;
        // Set current head's next pointer to null
        nodeToRemove.next = null;

        // Set newHead's previous pointer to null
        newHead.prev = null;

        // Set newHead as head
        head = newHead;

        // Decrement size
        size--;

        return nodeToRemove.element;
    }

    /**
     * Returns head of the list
     *
     * @return returns head element
     * @throws NoSuchElementException if list has no head i.e. the list is empty
     */
    public E peek() {
        // Checks if list is empty
        if (head == null) {
            throw new NoSuchElementException();
        }

        return head.element;
    }

    /**
     * Removes tail of the list and returns it
     *
     * @return returns removed element
     * @throws NoSuchElementException if list has no tail i.e. the list is empty
     */
    public E removeLast() {
        // Checks if list is empty
        if (tail == null) {
            throw new NoSuchElementException();
        }

        Node<E> nodeToRemove = tail;

        // Checks if tail is the only element in the list
        if (tail.prev == null) {
            head = null;
            tail = null;
            size = 0;
            return nodeToRemove.element;
        }

        Node<E> newTail = tail.prev;
        // Set current tail's previous pointer to null
        nodeToRemove.prev = null;
        // Set newTail's next pointer to null
        newTail.next = null;
        // Set newTail as tail
        tail = newTail;

        // Decrement size
        size--;

        return nodeToRemove.element;
    }

    /**
     * Removes element at position n in the list and returns it
     *
     * @param n position to remove element from
     * @return returns removed element
     * @throws IllegalArgumentException if the position given does not exist for list
     */
    public E removeAtPosition(int n) {
        // Checks if position exists
        if (n < 1 || n > size) {
            throw new IllegalArgumentException("No such position");
        }

        // Checks if element to be removed is head
        if (n == 1) {
            return removeFirst();
        }

        // Checks if element to be removed is tail
        if (n == size) {
            return removeLast();
        }

        int index = 1;
        Node<E> node = head;

        // Traverse till we get to position
        // PS: node != null check is not necessary because we already check if given index is valid
        // using if (n > size) 
        while (index != n) {
            node = node.next;
            index++;
        }

        Node<E> prev = node.prev;
        // Set the previous node's next pointer to the next node
        prev.next = node.next;
        // Set the next node's previous pointer to the previous node
        node.next.prev = prev;

        return node.element;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        if (node == null) {
            return "Linkedlist is empty!";
        }

        String linkedList = "";
        while (true) {
            if (node.next == null) {
                linkedList += "[" + node.element + "]";
                break;
            }

            linkedList += "[" + node.element + "] <=> ";
            node = node.next;
        }
        return linkedList;
    }
}