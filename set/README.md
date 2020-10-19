## Introduction
The Set represents unordered groups of unique items (as in mathematical sets). They’re used when the order of items you need to store is meaningless, or if you must ensure **no items in the group occurs more than once**. The most common Set operations are:
* `add(e)`: add an item to the set or produce an error if the item is already in the set.
* `list()`: list the items in the set.
* `delete(e)`: remove an item from the set.

*excerpt from Computer Science Distilled*

## Internals
The Set's internal implementation is very similar to that of the Map's, and like the Map, an **array** is the underlying data structure used by a Set. The difference is that the Set does not store any key-value mappings, it stores an independent object i.e. whatever object is passed in :). It is important that the objects to be stored in a set are **immutable**.

How does storing an object (`add(e)`) in a set work?
1. Generate a hash (a.k.a index for the underlying array) for the object (or element) **e**, using a hash function
2. Check if object (or element) **e** exists at index. It is this step that ensure uniqueness in a set. It is for this step that immutability is important
3. Store object (or element) **e** at the index generated
4. Handle collision, if necessary

How does listing all the values (`list()`) in a set work?
1. Print out all the objects (or elements) at each index of the array
*PS: This operation doesn't list out the elements in the order they were inserted - this is why we say sets are unordered. It lists them according to their location in the underlying array, which is based on the hash that was generated for each element.*

How does deleting an object (`delete(e)`) from a set work?
1. Generate a hash (a.k.a index for the underlying array) for the object (or element) **e**, using a hash function
2. Delete object (or element) **e**  at the index, if there's no collision
3. If there's a collision, traverse bucket at index to find the correct object and delete it

See explanation for **Hashing** and **Collision** [here](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/map#internals)

## Time Complexity

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
