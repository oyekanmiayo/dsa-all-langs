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
}