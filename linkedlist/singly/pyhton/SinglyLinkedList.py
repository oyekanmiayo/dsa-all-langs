#!/usr/bin/env python
__author__ = "Osamudiamen Azamegbe"


class Node:
    """An object that stores a unit of data and has a pointer to a next Node (if any)."""

    def __init__(self, value, nextNode=None):
        """initialize Node instance with unit of data and next pointer (if any)."""
        self.value = value
        self.next = nextNode


class SinglyLinkedList:
    """A Linked List made up of Node objects connected in a unidirectional chain-like manner."""

    def __init__(self):
        """initialize SinglyLinkedList instance with a head attribute, a tail attribute and size attribute.
        
        The head attribute is a pointer to the beginning of the SinglyLinkedList instance.
        The tail attribute is a pointer to the end of the SinglyLinkedList instance.
        The size attribute stores the current number of Node objects in the SinglyLinkedList instance.
        """
        self.head = None
        self.tail = None
        self.size = 0