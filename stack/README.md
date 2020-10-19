## Introduction
Picture a pile of papers. You can put a sheet onto the top of the pile, or take the top sheet off. The first sheet to be added is always the last to be removed. The Stack is used when we have a pile of items, and only work with its top item. The item on top is always the pile’s most recently inserted one. A Stack implementation must provide at least these operations:
* `push(e)`: add an item e to the top of the stack
* `pop()`: retrieve and remove the item on top of the stack
* `peek()`: retrieve the item on top of the stack

Processing data this way is know as **LIFO (Last-In, First-Out)**; we only ever remove items from the top, which always has the stack’s most recent insertion. The Stack is an important data type that occurs in many algorithms. For example, to implement the “undo” feature in your text editor, every edition you make is pushed onto a stack. Should you want to undo, the text editor pops an edition from the stack and reverts it.<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>

## Internals
An **array** is the underlying data structure used by a Stack.

How does inserting an item (`push(e)`) into a stack work?
1. Insert item in next available index in underlying array

How does removing an item (`pop()`) from a stack work?
1. Retrieve item from the last filled index in the underlying array and remove the reference to it

How does retrieving the top item (`peek()`) from a stack work?
1. Retrieve item from the last filled index in the underlying array


## Time Complexity
Time Complexities for operations mentioned [here](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/list#introduction).

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)