// Queue is an implementation of a queue using a doubly-linked list.
class Queue {
  constructor() {
    this.linkedList = new DoublyLinkedList();
  }

  // Adds an element to the back of the queue
  enqueue(element) {
    this.linkedList.addLast(element);
  }

  // Removes the element at the front of the queue
  dequeue() {
    return this.linkedList.removeFirst();
  }

  // Returns the element at the front of the queue
  peek() {
    return this.linkedList.peek();
  }
}
