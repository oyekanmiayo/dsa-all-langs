## Introduction
With Linked Lists, items are stored in a chain of cells that don’t need to be at sequential memory addresses (as it is in arrays). Memory for each cell is allocated as needed. Each cell has a pointer indicating the address of the next cell in the chain. A cell with an empty pointer marks the end of the chain<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

A singly linked list is a type of linked list that is **unidirectional**, that is, it can be traversed in only one direction from head to the last node (tail)<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>. Some operations on a singly linked list include:
* `addFirst(e)`: Add item to the front of the list
* `addLast(e)`: Add item to the back of the list
* `addAtPosition(n, e)`: Add item at specific position **n** in the list
* `removeFirst()`: Remove item from front of the list
* `removeLast()`: Remove item at the end of the list
* `removeAtPosition(n)`: Remove item at specific position **n** in the list

## Internals
Each element in a linked list is a node. A single node contains data and a pointer to the next node. The first node in the linkedlist is called the **head** and the last node is called the **tail**.<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

Linkedlists can be used to implement **Stacks**, **Lists** and **Queues**<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

How does adding an item to the front (`addFirst(e)`) of a singly linkedlist work?
1. Create new node to wrap element **e** 
2. Set the new node's pointer to the current head
3. Set new node as head

How does adding an item to the back (`addLast(e)` of a singly linkedlist work?
1. Starting at head node, traverse the linkedlist until tail node is reached
2. Create a new node to wrap element **e** 
3. Set the current tail node's pointer to the new node
4. Set new node as tail

How does adding an item to a specific position (`addAtPosition(n, e)`) in a singly linkedlist work?
1. Starting at head node, traverse the linkedlist until position **n** is reached
2. Create a new node to wrap element **e** 
3. Follow the insertion step for the condition that applies:
    * If there will be no node preceding the new node at position **n**, it means new node is the new head. Therefore, follow steps to `addFirst(e)` above
    * If there will be no node following the new node at position **n**, it means new node is the new tail. Therefore, follow steps to `addLast(e)` above
    * If there will be a preceding node and a following node for the new node at position **n**, then:
        - Set the preceding node's pointer to the new node
        - Set the new node's pointer to the following node
        - The two steps above perform the **insertion**

How does removing an item from the front (`removeFirst()`) of a singly linkedlist work?
1. Set head as the node the current head node points to

How does removing an item from the back (`removeLast()`) of a singly linkedlist work?
1. Starting at head, traverse  the list until one node before the current tail
2. Set this node's pointer to null. This ensures that nothing references the current tail, and that it will be garbage collected
3. Set this node as tail

How does removing an item from a specific position (`removeAtPosition(n)`) in a singly linkedlist work?
1. Starting at head node, traverse the linkedlist until position **n - 1** is reached
2. Follow the removal step for the condition that applies:
    * If there there is no node at **n - 1** (a.k.a preceding node of node to be removed), it means the node being deleted is the head node. Therefore, follow steps to `removeFirst()` above
    * If there is a preceding node, we set the preceding node's pointer to the following node of the node to be removed. This ensures that nothing references the node to be removed, and that it will be garbage collected

## Time Complexity

## Other Definitions

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

2. [What is a singly linked list?](https://www.educative.io/edpresso/what-is-a-singly-linked-list)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)