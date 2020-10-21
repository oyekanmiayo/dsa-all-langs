## Introduction
With Doubly Linked Lists (DLLs), items are stored in a chain of cells that don’t need to be at sequential memory addresses (as it is in arrays). Memory for each cell is allocated as needed. 

Each cell has two pointers: one indicates the address of the **previous cell** in the chain, and the other indicates the address of the **next cell** in the chain. A cell with an empty previous pointer marks the beginning of the chain while a cell with an empty next pointer marks end of the chain. 

Because a DLL has the two pointers described in the previous paragraph

The double pointers contained by each node in a DLL (as described in the previous paragraph) makes it **bi-directional**; We can traverse both forward and backward. This is the main difference between a DLL and a [Singly Linked List]() which can only be traversed in one direction - forward. Some operations on a DLL include:
* `addFirst(e)`: Add item to the front of the list
* `addLast(e)`: Add item to the back of the list
* `addAtPosition(n, e)`: Add item at specific position **n** in the list
* `removeFirst()`: Remove item from front of the list
* `removeLast()`: Remove item at the end of the list
* `removeAtPosition(n)`: Remove item at specific position **n** in the list

## Internals
Each element in a linked list is a node. A single node contains data and a pointer to the next node. The first node in the linkedlist is called the **head** and the last node is called the **tail**.<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

Linkedlists can be used to implement **Stacks**, **Lists** and **Queues**<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.
Because of the extra pointer, DLLs use more space than SLLs.

## Time Complexity

## Other Definitions

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)