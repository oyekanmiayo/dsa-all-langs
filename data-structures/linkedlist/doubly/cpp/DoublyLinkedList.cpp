#include <iostream>
#include <stdexcept>

/**
 * @author: Jennifer Chukwu
 */

template <class T> class DoublyLinkedList {

private:
  /**
   * This represents the template for the node object that is used in the
   * linkedlist
   */
  struct Node {
    T element;
    Node *prev;
    Node *next;

    Node(T element) : element(element), prev(nullptr), next(nullptr) {}
  };

  Node *head;
  Node *tail;
  int size;

public:
  DoublyLinkedList() : head(nullptr), tail(nullptr), size(0) {}

  /**
   * Destructor: Ensures all nodes are deleted when the list is destroyed
   *
   */
  ~DoublyLinkedList() {
    Node *current = head;

    // Traverse and delete all nodes
    while (current != nullptr) {
      Node *next = current->next;
      delete current;
      current = next;
    }
  }

  /**
   * Add element to front of the list, so that it becomes new head node
   *
   * @param element element that the new node created wraps around
   */

  void addFirst(T element) {
    // Create new node to wrap element
    Node *newHead = new Node(element);
    // Set the new node's pointer to the current head
    newHead->next = head;

    // Set the current head's previous pointer to new node, if current head
    // exists
    if (head != nullptr) {
      head->prev = newHead;
    }

    // Set new node as head
    head = newHead;

    // If tail hasn't be set, tail is equal to head
    if (tail == nullptr) {
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

  void addLast(T element) {
    if (size == 0) {
      addFirst(element);
      return;
    }

    Node *newNode = new Node(element);
    // Set the current tail node's next pointer to the new node
    tail->next = newNode;

    // Set the new node's previous pointer to current tail node
    newNode->prev = tail;

    // Set new node as tail
    tail = newNode;

    // Increment size
    size++;
  }

  /**
   * At element at any position in the list
   *
   * @param n represents position to insert element into.
   * @param element represents element to be inserted into position n
   * @throws out_of_range Exception if the position given does not exist for
   * list
   */
  void addAtPosition(int n, T element) {
    // Checks if position exists
    if (n < 1 || n > size) {
      throw std::out_of_range("Position out of range");
    }

    // Checks if element to be added will be the new head
    if (n == 1) {
      addFirst(element);
      return;
    }

    int index = 1;
    Node *node = head;
    Node *newNode = new Node(element);

    // Traverse till we get to position
    // PS: node != null check is not necessary because we already check if given
    // index is valid using if (n > size)
    while (index != n) {
      node = node->next;
      index++;
    }

    Node *prev = node->prev;

    // Update pointers to reference new node
    prev->next = newNode;
    newNode->prev = prev;
    newNode->next = node;
    node->prev = newNode;

    // Increment size
    size++;
  }

  /**
   * Removes head of the list and returns it
   *
   * @return returns removed element
   * @throws NoSuchElementException if list has no head i.e. the list is empty
   */
  T removeFirst() {
    // Checks if list is empty
    if (head == nullptr) {
      throw std::out_of_range("List is empty");
    }

    // Removes reference to head element
    Node *nodeToRemove = head;

    // Checks if head element is the only element in the list
    if (head->next == nullptr) {
      head = nullptr;
      tail = nullptr;
      size = 0;
      return nodeToRemove->element;
    }

    head = head->next;
    head->prev = nullptr;

    // Decrements size
    size--;

    return nodeToRemove->element;
  }

  /**
   * Removes tail of the list and returns it
   *
   * @return returns removed element
   * @throws NoSuchElementException if list has no tail i.e. the list is empty
   */
  T removeLast() {
    // Checks if list is empty
    if (tail == nullptr) {
      throw std::out_of_range("List is empty");
    }

    Node *nodeToRemove = tail;

    // Checks if tail is the only element in the list
    // If head.next is null, it means head == tail :)
    if (tail->prev == nullptr) {
      head = nullptr;
      tail = nullptr;
      size = 0;
      return nodeToRemove->element;
    }

    Node *newTail = tail->prev;
    // Set current tail's previous pointer to null
    nodeToRemove->prev = nullptr;
    // Set newTail's next pointer to null
    newTail->next = nullptr;
    // Set newTail as tail
    tail = newTail;

    // Decrement size
    size--;

    return nodeToRemove->element;
  }

  /**
   * Removes element at position n in the list and returns it
   *
   * @param n position to remove element from
   * @return returns removed element
   * @throws out_of_range Exception if the position given does not exist for
   * list
   */
  T removeAtPosition(int n) {
    // Checks if position exists
    if (n < 1 || n > size) {
      throw std::out_of_range("Position out of range");
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
    Node *node = head;

    // Traverse till we get to position
    // PS: node != null check is not necessary because we already check if given
    // index is valid using if (n > size)
    while (index != n) {
      node = node->next;
      index++;
    }

    Node *prev = node->prev;
    // Set the previous node's next pointer to the next node
    prev->next = node->next;
    // Set the next node's previous pointer to the previous node
    node->next->prev = prev;

    // Decrement size
    size--;

    return node->element;
  }

  void Print() {
    std::cout << "List contents: " << std::endl;
    Node *current = head;
    while (current != nullptr) {
      std::cout << current->element << " ";
      current = current->next;
    }
    std::cout << std::endl;
  }
};

int main() {
  DoublyLinkedList<int> list;

  list.addFirst(2);
  list.Print(); // [2]
  list.addLast(3);
  list.Print(); // [2] => [3]
  list.addAtPosition(2, 9);
  list.Print(); // [2] => [9] => [3]
  std::cout << "removed At Position [1]" << list.removeAtPosition(1)
   << std::endl;
  list.Print(); // [9] => [3]
  std::cout << "removed First" << list.removeFirst() << std::endl;
  list.Print(); // [3]
  std::cout << "removed Last " << list.removeLast() << std::endl;
  list.Print(); // Linkedlist is empty!
}