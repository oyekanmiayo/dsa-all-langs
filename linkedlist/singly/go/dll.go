package main

import (
	"fmt"

	"github.com/pkg/errors"
)

// DllNode is an element in the linked list
type DllNode struct {
	element interface{}
	prev    *DllNode
	next    *DllNode
}

func (n *DllNode) String() string {
	if n == nil {
		return "nil"
	}
	return fmt.Sprintf("%s", n.element)
}

// NewDllNode returns a new node
func NewDllNode(element interface{}) *DllNode {
	return &DllNode{
		element: element,
		prev:    nil,
		next:    nil,
	}
}

// DoublyLinkedList is a unidirectional linked list
type DoublyLinkedList struct {
	head *DllNode
	tail *DllNode
	size int
}

// NewDoublyLinkedList returns a new singly-linked list
func NewDoublyLinkedList() *DoublyLinkedList {
	return &DoublyLinkedList{}
}

// AddFirst adds an element to the front of the list so that it becomes the new head node
func (l *DoublyLinkedList) AddFirst(element interface{}) {
	newHead := NewDllNode(element)

	if l.tail == nil {
		l.tail = newHead
	} else {
		l.head.prev = newHead
	}

	newHead.next = l.head
	l.head = newHead

	l.size++
}

// AddLast adds an element to the back of the list so that it becomes the new tail node
func (l *DoublyLinkedList) AddLast(element interface{}) {
	if l.tail == nil {
		l.AddFirst(element)
		return
	}

	newTail := NewDllNode(element)
	newTail.prev = l.tail
	l.tail.next = newTail
	l.tail = newTail
	l.size++
}

// AddAtPosition adds an element to a specified position in the list
func (l *DoublyLinkedList) AddAtPosition(n int, element interface{}) error {
	if n < 1 || n > l.size+1 {
		return errors.New("no such position")
	}

	if n == 1 {
		l.AddFirst(element)
		return nil
	}

	if n == l.size+1 {
		l.AddLast(element)
		return nil
	}

	prev, node := l.head, l.head
	for i := 1; i < n; i++ {
		prev = node
		node = node.next
	}

	newNode := NewDllNode(element)
	newNode.next = node
	node.prev = newNode
	newNode.prev = prev
	prev.next = newNode

	l.size++
	return nil
}

// RemoveFirst removes the head of the list and returns it
func (l *DoublyLinkedList) RemoveFirst() (interface{}, error) {
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
	l.head.prev = nil
	l.size--
	return node.element, nil
}

// RemoveLast removes the tail of the list and returns it
func (l *DoublyLinkedList) RemoveLast() (interface{}, error) {
	if l.tail == nil {
		return nil, errors.New("no such element")
	}

	if l.head.next == nil {
		return l.RemoveFirst()
	}

	node := l.tail
	l.tail = l.tail.prev
	l.tail.next = nil

	l.size--
	return node.element, nil
}

// RemoveAtPosition removes the element at the specified position in the list and returns it
func (l *DoublyLinkedList) RemoveAtPosition(n int) (interface{}, error) {
	if n < 1 || n > l.size+1 {
		return nil, errors.New("no such position")
	}

	if n == 1 {
		return l.RemoveFirst()
	}

	if n == l.size {
		return l.RemoveLast()
	}

	prev := l.head
	node := l.head
	for i := 1; i < n; i++ {
		prev = node
		node = node.next
	}

	prev.next = node.next
	node.next.prev = prev
	l.size--
	return node.element, nil
}

func (l DoublyLinkedList) String() string {
	var str string
	curr := l.head
	str += fmt.Sprint(curr)
	if curr != nil {
		for curr.next != nil {
			curr = curr.next
			str += fmt.Sprintf("<->%s", curr)
		}
	}
	return str
}

func main() {
	list := NewDoublyLinkedList()
	fmt.Println(list)

	list.AddFirst("1")
	fmt.Println(list)
	list.AddLast("2")
	fmt.Println(list)
	list.AddAtPosition(2, "3")
	fmt.Println(list)

	list.RemoveAtPosition(2)
	fmt.Println(list)
	list.RemoveFirst()
	fmt.Println(list)
	list.RemoveLast()
	fmt.Println(list)

	// nil
	// 1
	// 1<->2
	// 1<->3<->2
	// 1<->2
	// 2
	// nil
}
