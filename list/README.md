## Introduction
A List is a data structure that is used to store objects. In languages like Java, all elements in a list need to be of the same type, however, in other languages like Ruby, elements of different types can be in the same list. What's special about a List is the flexibility it provides. Some common operations include:
* `add(e)`: insert item **e** at the end of the list
* `add(n, e)`: insert item **e** at index **n**
* `remove(n)`: remove the item at index **n**
* `get(n)`: get the item at position **n**
* `sort()`: sort the items in the list
* `slice(start, end)`: return a sub-list slice starting at the position start up until the position end
* `reverse()`: reverse the order of the list

###### PS: Operations can be named differently in different languages

## Internals
An **array** is the underlying data structure used by a List. One important difference between a List and an array is that a List does not have a fixed size - what this really means is that anytime the underlying array of a List instance is about to get filled, all the items are copied to a bigger array in an abstracted way.

How does inserting at item (`add(e)`) in a list work?
1. Check if the underlying array is filled
2. If it is not, 
    a. insert element **e** in the next available index in the array
3. If it is, 
    a. copy all elements in the current underlying array to a bigger array
    b. insert element **e** in the next available index in the new, bigger array

How does inserting an item at an index (`add(n, e)`) in a list work?
1. Check if the underlying array is filled
2. 

How does removing an item (`remove(n)`) from a list work?
How does retrieving an item (`get(n)`) from a list work?
How does sorting (`sort()`) a list work?
How does retrieving a sublist (`slice(start, end)`) from a list work?
How does reversing the order (`reverse()`) of a list work?

## Time Complexity

## References

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)