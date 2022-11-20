# Heap

## Introduction
By the time you’re reading this, you should know how a queue works. As a quick reminder, a queue works on the principle of first in first out. If you get to a supermarket line first, I expect to be attended to first and if I get there second, I expect to be attended to second. Same as ATM lines, cafe lines and so on.

But suppose we are at the hospital: If I’m on the line to see the doctor because I suspect I have a cold, but someone else stumbles in with blood gushing out of their side, I expect that person to be treated _immediately_. Even though I got to the queue first, this patient was _rightly_ removed from the queue before me. They were “prioritised”.

Consider another example: every time you carry out an action on your computer, jobs get scheduled and executed on the CPU. Some actions include, opening an app, typing into an app, transferring files from one directory to the other and so on. The jobs don’t always get scheduled on the CPU in the order they were carried out - sometimes a job takes “priority”.

The queues in the two above examples don’t operate with FIFO, but with something I call HPF (Highest Priority First). It follows then, that every person or job on the queue has a priority associated with it. When a collection of objects is organised by importance or priority, we call this a  priority queue[^1].

A normal queue data structure will not implement a priority queue efficiently because search for the element with highest priority will take O(n) time. A list, whether sorted or not, will also require O(n) time for either insertion or removal. A BST that organises records by priority could be used, with the total of n inserts and n remove operations requiring O(nlogn) time in the average case. However, there is always the possibility that the BST will become unbalanced, leading to bad performance[^1]. 

[^1]: https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/Heaps.html

So, we need a _new_ data structure to implement the priority queue ADT - this structure is called a Heap!  A Heap is a data structure that makes it easy to access the highest priority element in a queue.

(A Heap is implemented as a [complete binary tree](https://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html) - more on that later - which means each node has at most 2 children. This means a Heap is analogous with a Binary Heap.)

## Types
There are two types of heaps. The highest priority element (HPE) in a heap is determined by the type of heap it is. 

1. **Max Heap.** In a binary max heap, the root node represents the biggest or maximum item on the tree. The property is also true for all subtrees in the tree i.e The parent node must be greater than the child node. 

    In a Max Heap, the HPE is the maximum element.

2. **Min Heap.** In a binary min-heap, the root node represents the smallest or minimum item on the tree. The property is also true for all its subtrees in the tree i.e The parent node must be smaller than the child node.

    In a Min Heap, the HPE is the minimum element.

<img src="images/MinHeapAndMaxHeap.png" height="auto" width="400"/> [^2]

[^2]: https://www.geeksforgeeks.org/heap-data-structure/

(The rest of this document assumes we are using a max heap. This will be true except otherwise stated.)

Some operations we can perform on a Binary Heap include:
* `insert(value)`
* `peek()`
* `remove()`

## Internals
The [binary] heap is an implementation of a complete binary tree, which means every level is filled except possibly the last level; the last level is filled in from left to right! This is what makes the heap particularly more efficient than the BST.

Because a binary heap is a complete binary tree, we can implement it with an array using the following formulas to understand our relationships

Given a heap with n nodes and a node with an index z

**0-indexed array**
```
* parent(z) = `(z - 1)/2`, if z > 0
* leftChild(z) = `2z + 1`, if 2z + 1 < n
* rightChild(z)  =  `2z + 2`, if 2z + 2 < n
* leftSibling(z) = `z - 1`, if z is even and z > 0
* rightSibling(z) = `z + 1`, if z is odd and z  + 1 < n
```

**1-indexed array**
Index 0 still exists, but we skip it.

```
* parent(z) = `z/2`, if z > 0
* leftChild(z) = `2z`, if 2z  < n
* rightChild(z)  =  `2z + 1`, if 2z + 1 < n
* leftSibling(z) = `z - 1`, if z is even and z > 0
* rightSibling(z) = `z + 1`, if z is odd and z  + 1 < n
```

We can understand better with and example. [100, 40, 50, 10, 15, 50, 40] is a valid heap, draw it out yourself using the 0-indexed formulas above. We can also visualize using using [OpenDSA's](https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/Heaps.html) notes or [visual algo](https://visualgo.net/en/heap).

### Operations

1. `insert()`  = insertAtNextIndex() + heapifyUp()

    `insertAtNextIndex `

    ```
    Pseudocode:
    1. add element to next available index in array
    ```

    Time complexity for insertAtNextIndex is O(1).

    `heapifyUp`

    a.k.a bottom-up sort, bubble-up, sift-up etc.  

    We use this method to ensure that the heap obeys the heap property (min or max) after an insert. 

    Elements being inserted into the heap are always added at the next available index in the array, which is on the last level in the heap. Remember that in a max heap, the root must be greater than all its children and this must be true for all subtrees.  So, this method checks that the newly inserted node is in the right position.

    ```
    Pseudocode:
    1. get the parent of the newly insert node
    2. if the node > parent, then swap their positions
    3. repeat 1 and 2, until we get to the top or the condition fails
    ```


    **Time Complexity** :  Time to insertAtNextIndex * Time to heapifyUp.

    | insertAtNextIndex    | heapifyUp                  | Worst Case for insert |
    |----------------------|----------------------------|-----------------------|
    | Constant Time / O(1) | Logarithmic Time / O(logN) | O(logN)               |

    **Space Complexity** :  No matter what the value being inserted is, only one node is used. This means the amount of space used doesn’t grow with the value being inserted. This is true for integer values (primary data types?)

    This is a bit more interesting to think about in terms of objects though. Remember that the node itself will only store pointers. But each pointer points to an area of memory storing the values. Say the objects store names (so strings), the amount of space being used by each name stored is dependent on the name being stored in the object. If I think about it this deeply, then space could be O(n). 

    So, my final answer is O(1) for primary data types and objects only storing primary data types and O(n) for objects storing anything else. 

    | Worst Case for insert                                                                                    |
    |----------------------------------------------------------------------------------------------------------|
    | O(1) for primary data types or objects storing primary data types O(N) for objects storing anything else |

2. `remove()` = swapRootAndLastIndex() + removeLastIndex()  + heapifyDown()

    `swapRootAndLastIndex`

    ```
    Pseudocode:
    1. Swap element at index 0 with last element
    ```

    `removeLastIndex`

    ```
    Pseudocode:
    1. Remove element at last index
    ```


    `heapifyDown`

    We use this method to ensure that the heap obeys the heap property (min or max) after a deletion. 

    The swap we did earlier has most likely left the heap is a state that doesn’t obey the heap property. Remember that in a max heap the root must be greater than all its children and this must be true for all subtrees.  So, this method checks that the swapped root node is in the right position.

    ```
    Pseudocode:
    1. get the left and right children of the root node using the relevant formulas
    2. if left and right children are null, we're done
    3. if root node < left && left > right, then swap with left. else swap with right
    4. repeat 1 - 3 until we get to the last index or a condition fails
    ```

    **Time Complexity** : where **N** = is the number of nodes in the heap
    | swapRootAndLastIndex | removeLastIndex      | heapifyDown                | Worst Case for remove      |
    |----------------------|----------------------|----------------------------|----------------------------|
    | Constant Time / O(1) | Constant Time / O(1) | Logarithmic Time / O(logN) | Logarithmic Time / O(logN) |

    **Space Complexity** : no new node is added!
    | Worst Case for remove |
    |-----------------------|
    | Constant Time / O(1)  |

3. `peek()`
    
    ```
    Pseudocode:
    * return the node at index 0 (this will be the min or max value depending on the type of heap it is)
    ```

    **Time Complexity**: Constant Time or O(1)
    
    | Worst Case for `peek()`|
    |-----------------------|
    | Constant Time / O(1)|

    **Space  Complexity** : No extra space is used in this method. Constant Space or O(1)
    
    | Worst Case for `peek()`|
    |-----------------------|
    | Constant Space / O(1)|


## Additional Notes
* The heap itself has a Space Complexity of O(N) - where N is the number of nodes in the heap
* Building a heap is an O(NlogN) operation

## Examples
* Java: https://replit.com/@oyekanmiayo/PriorityQueue#Main.java
* Python: https://replit.com/@oyekanmiayo/PriorityQueuePython#main.py

## References
1. [Heap Data structure](https://www.geeksforgeeks.org/heap-data-structure/)
2. [complete binary tree](https://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html) 
3. [Binary Trees](https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/CompleteTree.html)
4. [Heap: TutorialHorizon](https://algorithms.tutorialhorizon.com/binary-min-max-heap/)
5. [Heap: Visual Algo](https://visualgo.net/en/heap)

## Author(s)
* [Ogooluwa Akinola](https://github.com/rovilay)
* Ayomide Oyekanmi  
