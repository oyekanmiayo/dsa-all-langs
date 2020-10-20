## Introduction
Picture a pile of papers. You can put a sheet onto the top of the pile, or take the top sheet off. The first sheet to be added is always the last to be removed. The Stack is used when we have a pile of items, and only work with its top item. The item on top is always the pile’s most recently inserted one. A Stack implementation must provide at least these operations:
* `push(e)`: add an item e to the top of the stack
* `pop()`: retrieve and remove the item on top of the stack
* `peek()`: retrieve the item on top of the stack

Processing data this way is know as **LIFO (Last-In, First-Out)**; we only ever remove items from the top, which always has the stack’s most recent insertion. The Stack is an important data type that occurs in many algorithms. For example, to implement the “undo” feature in your text editor, every edition you make is pushed onto a stack. Should you want to undo, the text editor pops an edition from the stack and reverts it.<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>

## Internals
We can use an **array** or a **linkedlist** as the underlying data structure used by a Stack. Since arrays have a fixed size, if the number of elements being inserted into the stack exceeds this size, we will need to copy out all elements into a bigger array. Using a linkedlist helps avoid this extra overhead. We will consider the internals for both underlying structures

### Array as underlying structure
How does inserting an item (`push(e)`) into a stack work?
1. Check if size limit of underlying array has been reached
2. If it has, copy all elements in the current underlying array to a bigger array
3. Insert item in next available index in underlying array

How does removing an item (`pop()`) from a stack work?
1. Retrieve item from the last filled index in the underlying array and remove the reference to it

How does retrieving the top item (`peek()`) from a stack work?
1. Retrieve item from the last filled index in the underlying array

### Linkedlist as underlying structure
How does inserting an item (`push(e)`) into a stack work?
1. Add element to tail of the linkedlist

How does removing an item (`pop()`) from a stack work?
1. Remove element from tail of the linkedlist

How does retrieving the top item (`peek()`) from a stack work?
1. Return element at the tail of the linkedlist

## Time Complexity
Time Complexities for operations mentioned [here](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/list#introduction).

### Array as underlying structure
* `push(e)`: time to copy elements to bigger array + time to insert item at index
  | Time to copy elements to bigger array | Time to insert item at index | Worst Case for `push(e)` | Amortized Time for `push(e)` |
  |---------------------------------------|------------------------------|--------------------------|------------------------------|
  | Linear/O(N)                           | Constant Time/O(1)           | Linear/O(N)              | Constant Time/O(1)           |
  
* `pop()`: time to remove item reference from index
  | Time to remove item reference from index | Worst Case for `pop()`  |
  |------------------------------------------|-------------------------|
  | Constant Time/O(1)                       | Constant Time/O(1)      |

* `peek()`: time to retrieve item from index
  | Time to retrieve item from index | Worst Case for `peek()` |
  |----------------------------------|-------------------------|
  | Constant Time/O(1)               | Constant Time/O(1)      |

### Linkedlist as underlying structure
* `push(e)`: time to add item to tail of the linkedlist
* `pop()`: time to remove element from tail of the linkedlist
* `peek()`: time to return element at the tail of the linkedlist

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
