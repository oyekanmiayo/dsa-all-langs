"""
Author: Abdulazeez Abdulazeez Adeshina
"""

class Node:
    """
    This represents the template for the node object that is used for the linkedlist.
    """

    def __init__(self, element):
        """
        :param element: This represents the element contained in the Node.
        :type element: This element can be of any type ranging from strings, numbers, arrays etc.
        """
        self.element = element
        self.previous = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __len__(self) -> int:
        """
        :return: Length of the linkedlist
        :rtype: int
        """
        return self.size

    def addFirst(self, element):
        """
        The `addFirst` method adds a new node to the front of the list making it the head of the linkedlist.

        :param element: the value held in the Node.
        """

        # Create a new node to wrap the element
        newHead = Node(element)
        # Set the new node's next pointer to the current head

        newHead.next = self.head

        # Set the current head's previous pointer to the new node, if current head exists
        if self.head is not None:
            self.head.previous = newHead

        # Set the new node as the head
        self.head = newHead

        # Check if the tail node is absent.
        if self.tail == None:
            # If the tail node is absent, assign the head node to the tail node.
            self.tail = self.head

        # Increment linked list size.
        self.size += 1

    def addLast(self, element):
        """
        The `addLast` method adds a new node to the end of the list.

        :param element: the value held in the Node.
        """

        # Check to see if the list in empty
        if self.tail is None:
            self.addFirst(element)
            return

        # Create a new node to wrap element
        newTail = Node(element)

        # Set the current tail node's next pointer to the new node
        self.tail.next = newTail

        # Set the new node's previous pointer to the current tail node
        newTail.previous = self.tail

        # Set the new node as tail
        self.tail = newTail

        # Increment size
        self.size += 1

    def addAtPosition(self, position, element):
        """
        The `addAtPosition` method adds a new node to the specified position in the linkedlist if the position is valid.

        :param position: position of the new element to be added.
        :param element: the value held in the Node.
        :raise
        """

        # Check if position is valid
        if position < 1 or position > self.size:
            raise IndexError("Position is invalid")

        # Check of element to be added will be the new head
        if position == 1:
            self.addFirst(element)
            return

        index = 1
        current = self.head
        newNode = Node(element)

        # Traverse the linkedlist till we get to the position
        # using if (position > self.size)
        while index != position:
            index += 1
            current = current.next

        prev = current.previous

        # Set the preceeding node's next pointer to the new node
        prev.next = newNode
        # Set new node's previous pointer to the preceeding node
        newNode.previous = prev
        # Set the new node's next pointer to the following node
        newNode.next = current
        # Set the following node's previous pointer to the new node
        current.previous = newNode

        self.size += 1

    def removeFirst(self):
        """
        The `removeFirst` method removes the head of the linkedlist and returns it.

        :returns removed element
        """

        # Check if the list is empty
        if self.head is None:
            return "List is Empty!"

        # Check if the head element is the only element in the linkedlist
        if self.head.next is None:
            self.head = self.tail = None
            self.size = 0
            return

        # Removes reference to head element
        nodeToRemove = self.head

        newHead = self.head.next

        # Set current head's pointer to None
        nodeToRemove.next = None

        # Set newHead's previous pointer to None
        nodeToRemove.previous = None

        # Set newHead as head
        self.head = newHead

        # Decrement size
        self.size -= 1

        return nodeToRemove.element

    def peek(self):
        # Check if list is empty
        if self.head is None:
            return "Empty List!"

        return self.head.element

    def removeLast(self):
        """
        The `removeLast` method removes the tail of the linkedlist.

        :returns the removed element
        """

        # Check if linkedlist is empty
        if self.tail is None:
            return "No tail present in linkedlist!"

        # Check if the tail is the only element in the list

        if self.tail.previous is None:
            self.head = None
            self.tail = None
            self.size = 0
            return

        nodeToRemove = self.tail
        newTail = self.tail.previous

        # Set current tail's previous pointer to None
        nodeToRemove.previous = None
        # Set the newTail's next pointer to None
        newTail.next = None
        # Set the newTail as tail
        self.tail = newTail

        # Decrement size
        self.size -= 1

        return nodeToRemove.element


    def removeAtPosition(self, position):
        """
        The `removeAtPosition` method removes a node at the specified postion.

        :param position: position to remove element from
        :returns the removed element
        """

        # Check if position is valid
        if position < 1 or position > self.size:
            raise IndexError("Invalid position!")

        # Check if element to be removed is the head
        if position == 0:
            self.removeFirst()
            return

        # Check if element to be removed is the tail
        if position == self.size:
            self.removeLast()
            return

        index = 1
        current = self.head

        # Traverse till we get to position
        while index != position:
            index += 1
            current = current.next

        prev = current.previous

        # Set the previous node's next pointer to the next node
        prev.next = current.next

        # Set the next node's previous pointer to the previous node
        current.next.previous = prev

        # Decrement size
        self.size -= 1

        return current.element


"""
    The DoublyLinkedList() object will be instantiated and called as such:
    x = DoublyLinkedList()
    x.addFirst(1) # 1
    x.addLast(2) # 1 -> 2
    x.addFirst(3) # 3 -> 1 -> 2
    x.addAtPosition(2, 10) # 3 -> 10 -> 1 -> 2
    x.removeAtPosition(2) # 3 -> 1 -> 2
    len(x) # 3
"""