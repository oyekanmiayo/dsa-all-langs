## Introduction
With Singly Linked Lists (SLLs), items are stored in a chain of cells that don’t need to be at sequential memory addresses (as it is in arrays). Memory for each cell is allocated as needed. Each cell has a pointer indicating the address of the next cell in the chain. A cell with an empty pointer marks the end of the chain<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

An SLL is a type of linked list that is **unidirectional**, that is, it can be traversed in only one direction from head to the last node (tail)<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>. Some operations on a singly linked list include:
* `addFirst(e)`: Add item to the front of the list
* `addLast(e)`: Add item to the back of the list
* `addAtPosition(n, e)`: Add item at specific position **n** in the list
* `removeFirst()`: Remove item from front of the list
* `removeLast()`: Remove item at the end of the list
* `removeAtPosition(n)`: Remove item at specific position **n** in the list

## Internals
Each element in an SLL is wrapped by a node. A single node contains data and a pointer to the next node. The first node in the SLL is called the **head** and the last node is called the **tail**.<sup>[2](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

SLLs can be used to implement **Stacks**, **Lists** and **Queues**<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/linkedlist/singly#references)</sup>.

How does adding an item to the front (`addFirst(e)`) of a singly linkedlist work?
1. Create new node to wrap element **e** 
2. Set the new node's pointer to the current head
3. Set new node as head

How does adding an item to the back (`addLast(e)` of a singly linkedlist work?
1. Starting at head node, traverse the linkedlist until tail node is reached
2. Create a new node to wrap element **e** 
3. Set the current tail node's pointer to the new node
4. Set new node as tail

How does adding an item to a specific position (`addAtPosition(n, e)`) in an SLL work?
1. Starting at head node, traverse the linkedlist until position **n** is reached. Keep track of the **preceding node**
2. Create a new node to wrap element **e** 
3. Follow the insertion step for the condition that applies:
    * If there will be no node preceding the new node at position **n**, it means new node is the new head. Therefore, follow steps to `addFirst(e)` above
    * If there will be a preceding node and a following node for the new node at position **n**, then:
        - Set the preceding node's pointer to the new node
        - Set the new node's pointer to the following node
        - The two steps above perform the **insertion**
    ##### PS: It is not possible to get a condition to `addLast(e)` here because technically that position does not exist yet. To add element to back of the list, call `addLast(e)` directly.

How does removing an item from the front (`removeFirst()`) of an SLL work?
1. Set head as the node the current head node points to

How does removing an item from the back (`removeLast()`) of an SLL work?
1. Starting at head, traverse  the list until current tail node is reached. Keep track of the **preceding node**.
2. Set preceding node's pointer to null. This ensures that nothing references the current tail, and that it will be garbage collected
3. Set this preceding node as tail

How does removing an item from a specific position (`removeAtPosition(n)`) in an SLL work?
1. Starting at head node, traverse the linkedlist until position **n** is reached. Keep track of the **preceding node**
2. Follow the removal step for the condition that applies:
    * If there there is no preceding node, it means the node being deleted is the head node. Therefore, follow steps to `removeFirst()` above
    * If there is a preceding node, we set the preceding node's pointer to the following node of the node to be removed. This ensures that nothing references the node to be removed, and that it will be garbage collected

## Time Complexity
Time complexities for operations mentioned [here]()

* `addFirst(e)`: time to create new node + time to change head reference
   | Time to create new node | Time to change head reference | Worst Case for `addFirst(e)` |
   |-------------------------|-------------------------------|------------------------------|
   | Constant Time/O(1)      | Constant Time/O(1)            | Constant Time/O(1)           |

* `addLast(e)`: time to create new node + time to traverse linkedlist + time to change tail's reference
   | Time to create new node | Time to traverse linkedlist | Time to change tail's reference | Worst Case for `addLast(e)` |
   |-------------------------|-----------------------------|---------------------------------|-----------------------------|
   | Constant Time/O(1)      | Linear Time/O(N)            | Constant Time/O(1)              | Linear Time/O(N)            |

* `addAtPosition(n, e)`: time to create new node + time to traverse linkedlist + time to insert item at position **n**
   | Time to create new node | Time to traverse linkedlist | Time to insert item at position n | Worst Case for `addAtPosition(n, e)` |
   |-------------------------|-----------------------------|-----------------------------------|--------------------------------------|
   | Constant Time/O(1)      | Linear Time/O(N)            | Constant Time/O(1)                | Linear Time/O(N)                     |

* `removeFirst()`: time to remove current head reference
   | Time to remove current head reference | Worst Case for `removeFirst()` |
   |---------------------------------------|--------------------------------|
   | Constant Time/O(1)                    | Constant Time/O(1)             |

* `removeLast()`: time to traverse linkedlist + time to remove tail's reference
   | Time to traverse linkedlist | Time to remove tail's reference | Worst Case for `removeLast()` |
   |-----------------------------|---------------------------------|-------------------------------|
   | Linear Time/O(N)            | Constant Time/O(1)              | Linear Time/O(N)              |

* `removeAtPosition(n)`: time to traverse linkedlist + time to remove references to the item at position **n**
   | Time to traverse linkedlist | Time to remove references to item at position n | Worst Case for `removeAtPosition(n)` |
   |-----------------------------|-------------------------------------------------|--------------------------------------|
   | Linear Time/O(N)            | Constant Time/O(1)                              | Linear Time/O(N)                     |

## Other Definitions

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

2. [What is a singly linked list?](https://www.educative.io/edpresso/what-is-a-singly-linked-list)

3. [Garbage Collection in Programming](https://www.freecodecamp.org/news/a-guide-to-garbage-collection-in-programming/)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
