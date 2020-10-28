#!/usr/bin/env python
__author__ = "Osamudiamen Azamegbe"

from typing import Any, NewType, Optional


# defining custom data types
node = NewType("node", Any)

class Node:
    """An object that stores a unit of data and has a pointer to a next Node (if any)."""

    def __init__(self, value: Any, nextNode: Optional[node] = None) -> None:
        """initialize Node instance with unit of data and next pointer (if any)."""
        self.value = value
        self.next = nextNode


class SinglyLinkedList:
    """A Linked List made up of Node objects connected in a unidirectional chain-like manner."""

    def __init__(self):
        """initialize SinglyLinkedList (SLL) instance with a head attribute, a tail attribute and size attribute.
        
        The head attribute is a pointer to the beginning of the SinglyLinkedList instance.
        The tail attribute is a pointer to the end of the SinglyLinkedList instance.
        The size attribute stores the current number of Node objects in the SinglyLinkedList instance.
        """
        self.head = None
        self.tail = None
        self.size = 0

    def addFirst(self, element: Any) -> None:
        """Add a Node object storing `element` to the beginning of the SinglyLinkedList instance.

        Parameters
        ----------
        element: Any
            data to be stored in Node object.
        """
        # Create new node to store element.
        newNode = Node(element)

        # Set the new node's pointer to the current head.
        newNode.next = self.head

        # Set new node as head
        self.head = newNode

        # Set tail pointer to head pointer if it has not been set.
        if self.tail is None:
            self.tail = self.head

        # increase size of SLL
        self.size += 1

    def addLast(self, element: Any) -> None:
        """Add a Node object storing `element` to the end of the SinglyLinkedList instance.

        Parameters
        ----------
        element: Any
            data to be stored in Node object.
        """
        # Create new node to store element.
        newNode = Node(element)

        # If tail pointer and head pointers have not been set.
        # Else set the current tail next pointer to the new node and set new node as tail.
        if self.tail is None:
            self.tail = newNode
            self.head = self.tail
        else:
            self.tail.next = newNode
            self.tail = newNode
        
        # increase size of SLL
        self.size += 1