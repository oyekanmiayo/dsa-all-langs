## Introduction
With Linked Lists, items are stored in a chain of cells that don’t need to be at sequential memory addresses (as it is in arrays). Memory for each cell is allocated as needed. Each cell has a pointer indicating the address of the next cell in the chain. A cell with an empty pointer marks the end of the chain.<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>

A singly linked list is a type of linked list that is **unidirectional**, that is, it can be traversed in only one direction from head to the last node (tail)<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>. Some operations on a singly linked list include:
* `addFirst(node)`: Add item to the front of the list
* `addLast(node)`: Add item to the back of the list
* `addAtPosition(n, node)`: Add item at specific position **n** in the list
* `removeFirst()`: Remove item from front of the list
* `removeLast()`: Remove item at the end of the list
* `removeAtPosition(n)`: Remove item at specific position **n** in the list

## Internals
Each element in a linked list is a node. A single node contains data and a pointer to the next node. The first node in the linkedlist is called the **head** and the last node is called the **tail**.<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

Linkedlists can be used to implement **Stacks**, **Lists** and **Queues**.<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>

How does adding an item to the front (`addFirst(node)`) of a singly linkedlist work?
How does adding an item to the back (`addLast(node)` of a singly linkedlist work?
How does adding an item to a specific position (`addAtPosition(n, node)`) in a singly linkedlist work?
How does removing an item from the front (`removeFirst()`) of a singly linkedlist work?
How does removing an item from the back (`removeLast()`) of a singly linkedlist work?
How does removing an item from a specific position (`removeAtPosition(n)`) in a singly linkedlist work?


## Time Complexity

## Other Definitions

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

2. [What is a singly linked list?](https://www.educative.io/edpresso/what-is-a-singly-linked-list)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)