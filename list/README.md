## Introduction
A List is a data structure that is used to store elements. In languages like Java, all elements in a list need to be of the same type, however, in other languages like Ruby, elements of different types can be in the same list. What's special about a List is the flexibility it provides. Some common operations include:
* `add(e)`: insert item **e** at the end of the list
* `add(n, e)`: insert item **e** at index **n**
* `remove(n)`: remove the item at index **n**
* `get(n)`: get the item at position **n**
* `sort()`: sort the items in the list
* `slice(start, end)`: return a sub-list slice starting at the position start up until the position end
* `reverse()`: reverse the order of the list <sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/add-list-impl/list#references)</sup>

###### PS: Operations can be named differently in different languages

## Internals
An **array** is the underlying data structure used by a List. One important difference between a List and an array is that a List does not have a fixed size - what this really means is that anytime the underlying array of a List instance is about to get filled, all the items are copied to a bigger array in an abstracted way.

#### Operations
1. **`add(e)`**
    ```
    Pseudocode:
    * Check if the underlying array is filled
    * If it is not,
       - insert element **e** in the next available index in the array
    *  If it is,
        - copy all elements in the current underlying array to a bigger array
        - insert element **e** in the next available index in the new, bigger array
    ```

    **Time Complexity** : time to copy items to new array, if current array is filled + time to insert item into index
    | Time to copy items to new array | Time to insert item into index | Worst Case for `add(e)` |
    |---------------------------------|--------------------------------|-------------------------|
    | Linear Time/O(N)                | Constant Time/O(1)             | Linear Time/O(N)        |
    
2. **`add(n, e)`**
    ```
    Pseudocode:
    * Check if the underlying array is filled
    * If it is, copy all elements in the current underlying array to a bigger array
    * Move elements from index **n** forward by one index
    * Insert element **e** at index **n**
    ```
   
    **Time Complexity** : time to copy items to new array, if current array is filled + time to move items forward by one index + time to insert item into index
    | Time to copy items to new array | Time to move items forward by one index | Time to insert item into index | Worst Case for `add(n,e)` |
    |---------------------------------|-----------------------------------------|--------------------------------|---------------------------|
    | Linear Time/O(N)                | Linear Time/O(N)                        | Constant Time/O(1)             | Linear Time/O(N)          |


3. **`remove(n)`**
    ```
    Pseudocode:
    * Remove reference to item by setting index **n** to null
    * Move elements from index **n+1** to the end backward by one index
    ```
   
   **Time Complexity** : time to remove reference to item at index + time to move items backward by one index
   | Time to remove reference to item at index | Time to move items backward by one index | Worst Case for `remove(n)` |
   |-------------------------------------------|------------------------------------------|----------------------------|
   | Constant Time/O(1)                        | Linear Time/O(N)                         | Linear Time/O(N)           |

4. **`get(n)`**
    ```
    Pseudocode:
    * Check if index exists, if it doesn't, throws an Exception
    * Return element at index **n**
    ```
    **Time Complexity** : time to retrieve item from an index
    | Time to retrieve item from an index | Worst Case for `get(n)` |
    |-------------------------------------|-------------------------|
    | Constant Time/O(1)                  | Constant Time/O(1)      |
    
5. **`sort()`**
    ```
    Pseudocode:
    * Sort elements in ascending or descending order
    ```
    *If the elements are complex objects, the are sorted based on custom comparators*
    
    **Time Complexity** :  time to sort items in ascending/descending order, using the most efficient sorting algorithms
    | Time to sort items using most efficient algorithms | Worst Case for `sort()`    |
    |----------------------------------------------------|----------------------------|
    | Linearithmic Time/O(NlogN)                         | Linearithmic Time/O(NlogN) |
    
6. **`slice(start, end)`**
    ```
    Pseudocode:
    * Create a new list that is the size of the slice being requested
    * Insert all elements from start to end in existing list to new list
    ```
   
    **Time Complexity** : time to traverse original list + time to insert sliced items into new list
    | Time to traverse list | Time to insert sliced items into list                                       | Worst Case for `slice(start, end)` |
    |-----------------------|-----------------------------------------------------------------------------|------------------------------------|
    | Linear Time/O(N)      | Linear Time/O(K), K = size of slice. K can be equal to N in the worst case. | Linear Time/O(N)                   |
   
7. **`reverse()`**
    ```
    Pseudocode:
    * Reverse elements in the underlying array 
    ```
   
   **Time Complexity** : time to reverse elements in the underlying array 
   | Time to reverse elements in array | Worst Case for `reverse()` |
   |-----------------------------------|----------------------------|
   | Linear Time/O(N)                  | Linear Time/O(N)           |

## Terminologies
* **Comparator**: In electronics, a comparator is a device that compares two voltages or currents and outputs a digital signal indicating which is larger (read more [here](https://en.wikipedia.org/wiki/Comparator)). This works in a similar way in programming: a comparator is a function that compares two objects and outputs a integer indicating which is larger.

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)
