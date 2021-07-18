## Introduction
The Queue is the Stack’s antagonist. It’s also used for storing and retrieving items, but the retrieved item is always the one in front of the Queue, i.e., the one that has been on the queue the longest. Don’t be confused, that’s just like a real-life queue of people waiting in a restaurant<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>! The Queue’s essential operations are:
* `enqueue(e)`: add an item e to the back of the queue
* `dequeue()`: remove the item at the front of the queue
* `peek()`: get item at the front of the queue<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>

The Queue works by organizing data the **FIFO way (First-In, First-Out)**, because the first (and oldest) item that was inserted in the queue is always the first to leave the queue. Queues are used in many computing scenarios. If you are im- plementing an online pizza service, you will likely store the pizza orders in a queue<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>.

## Internals
We can use an **array** or a **doubly linked list (DLL)** as the underlying data structure used by a Queue. 

Because arrays have a fixed size, they don't provide the optimal performance for enqueue & dequeue. When enqueuing, if the array has reached its maximum size, we will need to copy out all elements into a bigger array. Additionally, everytime dequeuing is done, all elements need to shift by one index. 

Because of how doubly linked lists [work](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/linkedlist/doubly), it provides constant time for enqueuing and dequeuing. 

We will consider the internals for both underlying structures.

### Array as underlying structure

#### Operations
1. **`enqueue(e)`**
    ```
    Pseudocode:
    * Check if size limit of underlying array has been reached
    * If it has, copy all elements in the current underlying array to a bigger array
    * Insert item in next available index in underlying array
    ```
   
    **Time Complexity** : time to copy to bigger array + time to insert at index
    | Time to copy elements to bigger array | Time to insert item at index | Worst Case for `enqueue(e)` | Amortized Time for `enqueue(e)` |
    |---------------------------------------|------------------------------|-----------------------------|---------------------------------|
    | Linear/O(N)                           | Constant Time/O(1)           | Linear/O(N)                 | Constant Time/O(1)              |
    
    
2. **`dequeue()`**
    ```
    Pseudocode:
    * Remove item at index 0 in the underlying array 
    * Shift all the elements left by one index
    * Return removed item 
    ```
    
    **Time Complexity** : time to access element at index 0 + time to shift all elements left by one index
    | Time to access element | Time to shift all elements left by one index | Worst Case for `dequeue()` |
    |------------------------|----------------------------------------------|----------------------------|
    | Constant Time/O(1)     | Linear Time/O(N)                             | Linear Time/O(N)           |
    
3. **`peek()`**
    ```
    Pseudocode:
    * Retrieve item at index 0 in the underlying array  
    ```
    **Time Complexity** : time to access element at index 0
    | Time to access element | Worst Case for `peek()` |
    |------------------------|-------------------------|
    | Constant Time/O(1)     | Constant Time/O(1)      |

### DLL as underlying structure

#### Operations
1. **`enqueue(e)`**
    ```
    Pseudocode:
    * Add item to back of doubly linkedlist
    ```
   
    **Time Complexity** : time to add element to back of DLL
    | Time to add element to back of DLL  | Worst Case for `enqueue(e)` |
    |-------------------------------------|-----------------------------|
    | Constant Time/O(1)                  | Constant Time/O(1)          |


2. **`dequeue()`**
    ```
    Pseudocode:
    * Remove item from front of doubly linkedlist
    ```
   
    **Time Complexity** : time to remove element from front of DLL
    | Time to remove element from front of DLL | Worst Case for `dequeue()`  |
    |------------------------------------------|-----------------------------|
    | Constant Time/O(1)                       | Constant Time/O(1)          |
    
3. **`peek()`**
    ```
    Pseudocode:
    * Return the element at the front of the doubly linkedlist
    ```
   
    **Time Complexity** : time to get element at the front of DLL
    | Time to get element at the front of DLL | Worst Case for `peek()` |
    |-----------------------------------------|-------------------------|
    | Constant Time/O(1)                      | Constant Time/O(1)      |

As you can see, it is more efficient to use a DLL to implement a Queue.

## Reference(s)
1. [Computer Science Distilled](https://code.energy/computer-science-distilled/#get-your-copy)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
