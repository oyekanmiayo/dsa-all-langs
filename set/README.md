## Introduction
The Set represents unordered groups of unique items (as in mathematical sets). They’re used when the order of items you need to store is meaningless, or if you must ensure **no items in the group occurs more than once**. The most common Set operations are:
* `add(e)`: add an item to the set or produce an error if the item is already in the set.
* `contains(e)`: checks if an item exists in a set
* `list()`: list the items in the set.
* `remove(e)`: remove an item from the set.

*excerpt from Computer Science Distilled*

## Internals
The Set's internal implementation is very similar to that of the Map's, and like the Map, an **array** is the underlying data structure used by a Set. The difference is that the Set does not store any key-value mappings, it stores an independent object i.e. whatever object is passed in :). It is important that the objects to be stored in a set are **immutable**.

How does storing an object (`add(e)`) in a set work?
1. Generate a hash (a.k.a index for the underlying array) for the object (or element) **e**, using a hash function
2. Check if object (or element) **e** exists at index. See `contains(e)`'s description for more info.
3. Store object (or element) **e** at the index generated
4. Handle collision, if necessary

How does checking if an object (`contains(e)`) is in a set work?
1. Generate a hash (a.k.a index for the underlying array) for the object (or element) **e**, using a hash function
2. Check if object (or element) **e** exists at index. It is this step that ensure uniqueness in a set. It is for this step that immutability is important. To check if an object exists at an element, we traverse the bucket until we find it.

How does listing all the values (`list()`) in a set work?
1. Traverse each index in the underlying array
2. At each index's bucket and add each element found to a list
2. Return list
*PS: This operation doesn't list out the elements in the order they were inserted - this is why we say sets are unordered. It lists them according to their location in the underlying array, which is based on the hash that was generated for each element.*

How does removing an object (`remove(e)`) from a set work?
1. Generate a hash (a.k.a index for the underlying array) for the object (or element) **e**, using a hash function
2. Delete object (or element) **e**  at the index, if there's no collision
3. If there's a collision, traverse bucket at index to find the correct object and delete it

See explanation for **Hashing** and **Collision** [here](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/map#internals)

## Time Complexity
Time complexities for the operations mentioned [here](https://github.com/oyekanmiayo/data-structures-all-langs/blob/add-set-impl/set/README.md#introduction)

* `add(e)`: time to find address (always constant) + time to traverse bucket (depends on the data structure)
  | Time to find address | Bucket             | Time to traverse bucket  | Worst Case for `add(e)`  | Amortized Time     |
  |----------------------|--------------------|--------------------------|--------------------------|--------------------|
  | Constant Time/O(1)   | List               | Linear Time/O(N)         | Linear Time/O(N)         | Constant Time/O(1) |
  | Constant Time/O(1)   | LinkedList         | Linear Time/O(N)         | Linear Time/O(N)         | Constant Time/O(1) |
  | Constant Time/O(1)   | Binary Search Tree | Logarithmic Time/O(LogN) | Logarithmic Time/O(LogN) | Constant Time/O(1) |
  
* `contains(e)`: time to find address (always constant) + time to traverse bucket (depends on the data structure)
  | Time to find address | Bucket             | Time to traverse bucket  | Worst Case for `contains(e)` | Amortized Time     |
  |----------------------|--------------------|--------------------------|------------------------------|--------------------|
  | Constant Time/O(1)   | List               | Linear Time/O(N)         | Linear Time/O(N)             | Constant Time/O(1) |
  | Constant Time/O(1)   | LinkedList         | Linear Time/O(N)         | Linear Time/O(N)             | Constant Time/O(1) |
  | Constant Time/O(1)   | Binary Search Tree | Logarithmic Time/O(LogN) | Logarithmic Time/O(LogN)     | Constant Time/O(1) |
  
* `list()`: time to traverse array (linear) + time to traverse bucket at each index (depends on the data structure)
  | Time to traverse array | Bucket             | Time to traverse bucket  | Worst Case for `list()`  |
  |------------------------|--------------------|--------------------------|--------------------------|
  | Linear Time/O(N)       | List               | Linear Time/O(N)         | Linear Time/O(N)         |
  | Linear Time/O(N)       | LinkedList         | Linear Time/O(N)         | Linear Time/O(N)         |
  | Linear Time/O(N)       | Binary Search Tree | Logarithmic Time/O(LogN) | Logarithmic Time/O(LogN) |
  
* `remove(e)`: time to find address (always constant) + time to delete from bucket (depends on the data structure)
  | Time to find address | Bucket             | Time to delete from bucket | Worst Case for `remove(e)` | Amortized Time     |
  |----------------------|--------------------|----------------------------|----------------------------|--------------------|
  | Constant Time/O(1)   | List               | Linear Time/O(N)           | Linear Time/O(N)           | Constant Time/O(1) |
  | Constant Time/O(1)   | LinkedList         | Constant Time/O(1)         | Constant Time/O(1)         | Constant Time/O(1) |
  | Constant Time/O(1)   | Binary Search Tree | Logarithmic Time/O(LogN)   | Logarithmic Time/O(LogN)   | Constant Time/O(1) |

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
