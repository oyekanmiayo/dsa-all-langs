## Introduction
A **Map** is a data structure that is used to store mappings between two objects: a key and value pair. When you query a map with a key, you should get its associated value.

Some important operations for a map include:
* put(key, value) - add a key-value mapping to the map
* delete(key) - remove a key and it's associated value from the map
* get(key) - retrieve the associated value of a key from the map 

*PS: An **array** is the underlying data structure used by a map.*

## Internals
So how does (storing a value in a) map work?
1. Generate a hash (a.k.a memory address) for key, using a hash function
2. Store value at the hash (a.k.a memory address)
3. Handle collision, if necessary

Let's explain **Hash Function** and **Collision** a bit more.

### Hash Function
A hash function is a function that generates a (smaller) code for a given value by applying a known algorithm. The code that is generated represents the hash, which for us also doubles as the memory location where the value we want to store in our map will actually be stored. 

A lot of language implementations (e.g. Java, C# et al) use **prime numbers** in their algorithms to generate hashes. The reason for this is because a prime number is unique - its only factors are 1 and itself. This means that prime numbers give us the best chance of generating a unique hash. Prime numbers are also used as initial sizes for the internal arrays because they return more unique remainder values for each key (so better distribution).

### Collision
A collision happens when a hash function maps two (or more) different values to the same hash. This is inevitable as long as the hash space is smaller than the value space (e.g. Imagine we want to generate hashes for 0 - 2000, but our hashes can only be within 0 - 20. We will definitely encounter collisions). 

When handling collision, we want our strategies to answer two questions:
1. How will collided values be stores?
2. How will collided values be retrieved?

#### Strategies to handle collision:
1. **Separate Chaining**: We keep buckets at an address to handle collision i.e. instead of just storing one value at an index, we use a bucket so that we can store multiple values at that index. Doing this helps us solve the **storage** part of the collision problem. 

   Technically, a *bucket* is just an abstraction that translates to "any data structure that can help with storage". So these structure already come with inbuilt     mechanism to solve the **retrieval** part of the collision problem. This means that the worst case to fetch a value from a Map that has buckets at addresses =        time to find address (always constant) + time to traverse bucket (depends on the data structure).
   
   Some data structures that could be used as buckets include Lists (linear search), LinkedLists (linear search), Binary Search Trees (logarithmic search) and so on.
   
   In the Java implemenation in this repository, a LinkedList is used because it's simple enough to add to and traverse and delete from. Additionally, since we assume that our hash function is very good, the number of items in each buckets should so small that the time to search the LinkedList is trivial - this is why the time complexity for retrieving from a map is popularly constant or O(1) (amortized). 
   
   *PS: If there are too many items in a bucket, this is the cue to improve the hash function.*

2. **Open Addressing**: If there's a collision at the address (or hash or index), then we find the next available address to
place the value. The reason why this is called "Open Addressing" is because it's possible that the address the value is
stored in isn't the hash.

   Implementations: Linear Probing (+1), Quadratic Probing & Double Hashing

3. **2-Choice Hashing**: Here we compute the hash for a value using two hash functions and insert the value into the address
with less collisions.


## Other Definitions
* **Amortized Time**: Amortized time is the way to express the time complexity when an algorithm has the very bad time complexity only once in a while besides the time complexity that happens most of time. Read more [here](https://medium.com/@satorusasozaki/amortized-time-in-the-time-complexity-of-an-algorithm-6dd9a5d38045)

* **Load Factor**: The number of allowed entries per bucket. This isn't necessarily equal to the capacity of the bucket.

## References
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

2. [Why do hash functions use prime numbers](https://computinglife.wordpress.com/2008/11/20/why-do-hash-functions-use-prime-numbers/)

3. [Seperate Chaining (a technique to handle collisions)](https://en.wikipedia.org/wiki/Hash_table#Separate_chaining)

4. [Amortized Time Complexity of Algorithms](https://medium.com/@satorusasozaki/amortized-time-in-the-time-complexity-of-an-algorithm-6dd9a5d38045)
