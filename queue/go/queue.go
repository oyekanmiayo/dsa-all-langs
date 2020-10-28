package main

// Queue is an implementation of a queue
// using a doubly-linked list.
type Queue struct {
	linkedList doublyLinkedList
}

// Enqueue adds an element to the back of the queue.
func (q Queue) Enqueue(element interface{}) {
	q.linkedList.AddLast(element)
}

// Dequeue removes the element at the front of the queue
// and returns it. It returns an error if the queue is empty.
func (q Queue) Dequeue() (interface{}, error) {
	return q.linkedList.RemoveFirst()
}

// Peek returns the element at the front of the queue.
// It returns an error if the queue is empty.
func (q Queue) Peek() (interface{}, error) {
	return q.linkedList.Peek()
}

type doublyLinkedList interface {
	AddLast(element interface{})
	RemoveFirst() (interface{}, error)
	Peek() (interface{}, error)
}

// NewQueue returns a new Queue.
func NewQueue() Queue {
	return Queue{
		// linkedList: NewDoublyLinkedList(),
	}
}
