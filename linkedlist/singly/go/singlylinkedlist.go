package main

import (
	"fmt"

	"github.com/pkg/errors"
)

// Node is an element in the linked list
type Node struct {
	element interface{}
	next    *Node
}

// NewNode returns a new node
func NewNode(element interface{}) *Node {
	return &Node{
		element: element,
		next:    nil,
	}
}

// SinglyLinkedList is a unidirectional linked list
type SinglyLinkedList struct {
	head *Node
	tail *Node
	size int
}

// NewSinglyLinkedList returns a new singly-linked list
func NewSinglyLinkedList() *SinglyLinkedList {
	return &SinglyLinkedList{}
}

// AddFirst adds an element to the front of the list so that it becomes the new head node
func (l *SinglyLinkedList) AddFirst(element interface{}) {
	newHead := NewNode(element)
	newHead.next = l.head
	l.head = newHead

	if l.tail == nil {
		l.tail = l.head
	}

	l.size++
}

// AddLast adds an element to the back of the list so that it becomes the new tail node
func (l *SinglyLinkedList) AddLast(element interface{}) {
	node := l.head
	for node.next != nil {
		node = node.next
	}

	node.next = NewNode(element)
	l.tail = node.next

	l.size++
}

// AddAtPosition adds an element to a specified position in the list
func (l *SinglyLinkedList) AddAtPosition(n int, element interface{}) error {
	if n < 0 || n > l.size {
		return errors.New("no such position")
	}

	if n == 0 {
		l.AddFirst(element)
		return nil
	}

	prev, node := l.head, l.head
	for i := 0; i < n; i++ {
		prev = node
		node = node.next
	}

	newNode := NewNode(element)
	newNode.next = node
	prev.next = newNode

	l.size++
	return nil
}

// RemoveFirst removes the head of the list and returns it
func (l *SinglyLinkedList) RemoveFirst() (interface{}, error) {
	if l.head == nil {
		return nil, errors.New("no such element")
	}

	node := l.head
	if node.next == nil {
		l.head = nil
		l.tail = nil
		l.size = 0
		return node.element, nil
	}

	l.head = l.head.next
	l.size--
	return node.element, nil
}

// RemoveLast removes the tail of the list and returns it
func (l *SinglyLinkedList) RemoveLast() (interface{}, error) {
	if l.tail == nil {
		return nil, errors.New("no such element")
	}

	if l.head.next == nil {
		node := l.tail
		l.head = nil
		l.tail = nil
		l.size = 0
		return node.element, nil
	}

	prev := l.head
	node := l.head
	for node.next != nil {
		prev = node
		node = node.next
	}

	prev.next = nil
	l.tail = prev
	l.size--
	return node.element, nil
}

// RemoveAtPosition removes the element at the specified position in the list and returns it
func (l *SinglyLinkedList) RemoveAtPosition(n int) (interface{}, error) {
	if n < 0 || n > l.size {
		return nil, errors.New("no such position")
	}

	if n == 0 {
		return l.RemoveFirst()
	}

	if n == l.size {
		return l.RemoveLast()
	}

	prev := l.head
	node := l.head
	for i := 0; i < n; i++ {
		prev = node
		node = node.next
	}

	prev.next = node.next
	l.size--
	return node.element, nil
}

func main() {
	printList := func(list *SinglyLinkedList) {
		fmt.Printf("length=%d: ", list.size)
		curr := list.head
		if curr != nil {
			fmt.Printf("%s", curr.element)
			for curr.next != nil {
				curr = curr.next
				fmt.Printf(" => %s", curr.element)
			}
		}
		fmt.Println()
	}

	list := NewSinglyLinkedList()
	printList(list) //
	list.AddFirst("1")
	printList(list) // 1
	list.AddLast("2")
	printList(list) // 1, 2
	list.AddAtPosition(1, "3")
	printList(list) // 1, 3, 2

	list.RemoveAtPosition(1)
	printList(list) // 1, 2
	list.RemoveFirst()
	printList(list) // 2
	list.RemoveLast()
	printList(list) //
}
