#include <stdexcept>
#include <iostream>
/**
 * @author: Jennifer Chukwu
 */

template <class T>
class SinglyLinkedList
{

private:
    /**
     * This represents the template for the node object that is used in the linkedlist
     */
    struct Node
    {
        T element;
        Node *next;

        Node(T element) : element(element), next(nullptr) {}
    };

    Node *head;
    Node *tail;
    int size;

public:
    SinglyLinkedList() : head(nullptr), tail(nullptr), size(0) {}

    /**
     * Destructor: Ensures all nodes are deleted when the list is destroyed
     * 
     */
    ~SinglyLinkedList()
    {
        Node *current = head;

        // Traverse and delete all nodes
        while (current != nullptr)
        {
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

    void addFirst(T element)
    {
        // Create new node to wrap element
        Node *newHead = new Node(element);
        // Set the new node's pointer to the current head
        newHead->next = head;
        // Set new node as head
        head = newHead;

        // If tail hasn't be set, tail is equal to head
        if (tail == nullptr)
        {
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

    void addLast(T element)
    {
        Node *newNode = new Node(element);   
        if (tail != nullptr)
        {
            tail->next = newNode;
        }
        // Set new node as new tail node
        tail = newNode;

        // if list is empty, head and tail are same
        if (head == nullptr)
        {
            head = tail;
        }
        size++;
    }

    /**
     * At element at any position in the list
     *
     * @param n represents position to insert element into.
     * @param element represents element to be inserted into position n
     * @throws out_of_range Exception if the position given does not exist for list
     */
    void addAtPosition(int n, T element)
    {
        // Checks if position exists
        if (n < 1 || n > size)
        {
            throw std::out_of_range("Position out of range");
        }

        // Checks if element to be added will be the new head
        if (n == 1)
        {
            addFirst(element);
            return;
        }

        int index = 1;
        Node *prev = nullptr;
        Node *node = head;
        Node *newNode = new Node(element);

        // Traverse till we get to position
        // PS: node != null check is not necessary because we already check if given index is valid
        // using if (n > size)
        while (index != n)
        {
            prev = node;
            node = node->next;
            index++;
        }

        // Update pointers to reference new node
        prev->next = newNode;
        newNode->next = node;

        // Increment size
        size++;
    }

    /**
     * Removes head of the list and returns it
     *
     * @return returns removed element
     * @throws NoSuchElementException if list has no head i.e. the list is empty
     */
    T removeFirst()
    {
        // Checks if list is empty
        if (head == nullptr)
        {
            throw std::out_of_range("List is empty");
        }

        // Removes reference to head element
        Node *nodeToRemove = head;

        // Checks if head element is the only element in the list
        if (head->next == nullptr)
        {
            head = nullptr;
            tail = nullptr;
            size = 0;
            return nodeToRemove->element;
        }

        head = head->next;

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
    T removeLast()
    {
        // Checks if list is empty
        if (tail == nullptr)
        {
            throw std::out_of_range("List is empty");
        }

        // Checks if tail is the only element in the list
        // If head.next is null, it means head == tail :)
        if (head->next == nullptr)
        {
            Node *nodeToRemove = tail;
            head = nullptr;
            tail = nullptr;
            size = 0;
            return nodeToRemove->element;
        }

        // Traverses to the end of the list
        Node *prev = nullptr;
        Node *node = head;
        while (node->next != nullptr)
        {
            prev = node;
            node = node->next;
        }

        // Removes reference to current tail
        prev->next = nullptr;
        // Set the new tail
        tail = prev;

        // Decrements size
        size--;

        return node->element;
    }

    /**
     * Removes element at position n in the list and returns it
     *
     * @param n position to remove element from
     * @return returns removed element
     * @throws out_of_range Exception if the position given does not exist for list
     */
    T removeAtPosition(int n)
    {
        // Checks if position exists
        if (n < 1 || n > size)
        {
            throw std::out_of_range("Position out of range");
        }

        // Checks if element to be removed is head
        if (n == 1)
        {
            return removeFirst();
        }

        // Checks if element to be removed is tail
        if (n == size)
        {
            return removeLast();
        }

        int index = 1;
        Node *prev = nullptr;
        Node *node = head;

        // Traverse till we get to position
        // PS: node != null check is not necessary because we already check if given index is valid
        // using if (n > size)
        while (index != n)
        {
            prev = node;
            node = node->next;
            index++;
        }

        // Remove reference to node to be deleted
        prev->next = node->next;

        // Decrement size
        size--;

        return node->element;
    }

    void Print()
    {
        std::cout << "List contents: " << std::endl;
        Node *current = head;
        while (current != nullptr)
        {
            std::cout << current->element << " ";
            current = current->next;
        }
        std::cout << std::endl;
    }
};

int main()
{
    SinglyLinkedList<int> list;

    list.addFirst(2);
    list.Print();  // [2]
    list.addLast(3);
    list.Print();  // [2] => [3]
    list.addAtPosition(2, 9);
    list.Print();  // [2] => [9] => [3]
    std::cout<<"removed At Position [1]"<< list.removeAtPosition(1)<<std::endl;
    list.Print();  // [9] => [3]
    std::cout<< "removed First"<<list.removeFirst()<<std::endl;
    list.Print();  // [3]
    std::cout<<"removed Last "<<list.removeLast()<<std::endl;
    list.Print();  // Linkedlist is empty!
}