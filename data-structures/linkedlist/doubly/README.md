## Introduction
With Doubly Linked Lists (DLLs), items are stored in a chain of cells that don’t need to be at sequential memory addresses (as it is in arrays). Memory for each cell is allocated as needed. 

Each cell has two pointers: one indicates the address of the **previous cell** in the chain, and the other indicates the address of the **next cell** in the chain. A cell with an empty previous pointer marks the beginning of the chain while a cell with an empty next pointer marks end of the chain. 

The double pointers contained by each node in a DLL (as described in the previous paragraph) makes it **bi-directional**; We can traverse both forward and backward. This is the main difference between a DLL and a [Singly Linked List]() which can only be traversed in one direction: forward. Some operations on a DLL include:
* `addFirst(e)`: Add item to the front of the list
* `addLast(e)`: Add item to the back of the list
* `addAtPosition(n, e)`: Add item at specific position **n** in the list
* `removeFirst()`: Remove item from front of the list
* `removeLast()`: Remove item at the end of the list
* `removeAtPosition(n)`: Remove item at specific position **n** in the list

## Internals
Each element in a DLL is wrapped by a node. A single node contains data, a pointer to the previous node and a pointer to the next node - because of the extra pointer, DLLs use more space that SLLs. The first node in the linkedlist is called the **head** and the last node is called the **tail**.

DLLs can be used to implement **Stacks**, **Lists** and **Queues**.

#### Operations
1. **`addFirst(e)`**
    ```
    Pseudocode:
    * Create new node to wrap element **e** 
    * Set the new node's **next** pointer to the current head, if current head exists
    * Set the current head's **previous** pointer to new node, if current head exists
    * Set new node as head
    ```

    **Time Complexity** : time to create new node + time to change head reference
    | Time to create new node | Time to change head's reference | Worst Case for `addFirst(e)` |
    |-------------------------|-------------------------------|--------------------------------|
    | Constant Time/O(1)      | Constant Time/O(1)            | Constant Time/O(1)             |
    
2. **`addLast(e)`**
    ```
    Pseudocode:
    * If there is no tail node (i.e. the DLL is empty), call `addFirst(e)`
    * Else,
        - Get stored tail node reference
        - Create a new node to wrap element **e** 
        - Set the current tail node's **next** pointer to the new node
        - Set the new node's **previous** pointer to current tail node
        - Set new node as tail
    ```

    **Time Complexity** : time to create new node + time to change tail's reference
    | Time to create new node | Time to change tail's reference | Worst Case for `addLast(e)` |
    |-------------------------|---------------------------------|-----------------------------|
    | Constant Time/O(1)      | Constant Time/O(1)              | Constant Time/O(1)          |

3. **`addAtPosition(n, e)`**
    ```
    Pseudocode:
    * Starting at head node, traverse the linkedlist until position **n** is reached.
    * Create a new node to wrap element **e** 
    * Follow the insertion step for the condition that applies:
        - If there will be no node preceding the new node at position **n**, it means new node is the new head. Therefore, follow steps to `addFirst(e)` above
        - If there will be a preceding node and a following node for the new node at position **n**, then:
            * Set the preceding node's **next** pointer to the new node
            * Set new node's **previous** pointer to the preceding node
            * Set the following node's **previous** pointer  to the new node
            * Set the new node's **next** pointer to the following node
    ```
    * PS: It is not possible to get a condition to `addLast(e)` here because technically that position does not exist yet. To add element to back of the list, call `addLast(e)` directly.*
   
    **Time Complexity** : time to create new node + time to traverse linkedlist + time to insert item at position **n**
    | Time to create new node | Time to traverse linkedlist | Time to insert item at position n | Worst Case for `addAtPosition(n, e)` |
    |-------------------------|-----------------------------|-----------------------------------|--------------------------------------|
    | Constant Time/O(1)      | Linear Time/O(N)            | Constant Time/O(1)                | Linear Time/O(N)                     |
    
4. **`removeFirst()`**
    ```
    Pseudocode:
    * If current head is the only node in the DLL, then set head to null
    * Else,
        - Let's call current head's next node newHead (because it will be the new head node)
        - Set current head's **next** pointer to null
        - Set newHead's **previous** pointer to null
        - Set newHead as head
    ```
   
    **Time Complexity** : time to remove current head reference
    | Time to remove current head reference | Worst Case for `removeFirst()` |
    |---------------------------------------|--------------------------------|
    | Constant Time/O(1)                    | Constant Time/O(1)             |

5. **`removeLast()`**
    ```
    Pseudocode:
    * Get stored tail node reference
    * If tail node is the only node in the DLL, then set tail to null & head to null (because head == tail here)
    * Else,
        - Let's call current tails's previous node newTail (because it will be the new tail node)
        - Set current tail's **previous** pointer to null
        - Set newTail's **next** pointer to null
        - Set newTail as tail
    ```
   
    **Time Complexity** : time to remove tail's reference
    | Time to remove tail's reference | Worst Case for `removeLast()` |
    |---------------------------------|-------------------------------|
    | Constant Time/O(1)              | Constant Time/O(1)            |

6. **`removeAtPosition(n)`**
    ```
    Pseudocode:
    * Starting at head node, traverse the DLL until position **n** is reached
    * Follow the removal step for the condition that applies:
        - If node to be removed is the head, call `removeFirst()` above
        - If node to be removed is the tail, call `removeLast()` above
        - If node is a middle node (i.e. is has both previous and next nodes), then
            * Set the previous node's **next** pointer to the next node
            * Set the next node's **previous** pointer to the previous node
    ```
    * When references a node is removed, it will be garbage collected, if the programming language offers that*
   
    **Time Complexity** : time to traverse linkedlist + time to remove references to the item at position **n**
    | Time to traverse linkedlist | Time to remove references to item at position n | Worst Case for `removeAtPosition(n)` |
    |-----------------------------|-------------------------------------------------|--------------------------------------|
    | Linear Time/O(N)            | Constant Time/O(1)                              | Linear Time/O(N)                     |
 
## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)
2. [What is a doubly linked list](https://www.educative.io/edpresso/what-is-a-doubly-linked-list)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
