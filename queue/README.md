## Introduction
The Queue is the Stack’s antagonist. It’s also used for storing and retrieving items, but the retrieved item is always the one in front of the Queue, i.e., the one that has been on the queue the longest. Don’t be confused, that’s just like a real-life queue of people waiting in a restaurant<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>! The Queue’s essential operations are:
* `enqueue(e)`: add an item e to the back of the queue
* `dequeue()`: remove the item at the front of the queue
* `peek()`: get item at the front of the queue<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>

The Queue works by organizing data the **FIFO way (First-In, First-Out)**, because the first (and oldest) item that was inserted in the queue is always the first to leave the queue. Queues are used in many computing scenarios. If you are im- plementing an online pizza service, you will likely store the pizza orders in a queue<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/stack#references)</sup>.

## Internals
We can use an **array** or a **linkedlist** as the underlying data structure used by a Queue. 

Because arrays have a fixed size, they don't provide the optimal performance for enqueue & dequeue. When enqueuing, if the array has reached its maximum size, we will need to copy out all elements into a bigger array. Additionally, everytime dequeuing is done, all elements need to shift by one index. 

Because of how linkedlists [work](), it provides constant time for enqueuing and dequeuing. 

We will consider the internals for both underlying structures.

## Time Complexity

## Reference(s)
1. [Computer Science Distilled](https://www.amazon.co.uk/Computer-Science-Distilled-Computational-Problems/dp/0997316020/ref=sr_1_1?adgrpid=52658140545&dchild=1&gclid=Cj0KCQjw8fr7BRDSARIsAK0Qqr6bz1aEFd_X517mpcZBAGaDJaeg-WARxB6mwEMMtupTPnTGI0a-1SIaAmH5EALw_wcB&hvadid=259122221401&hvdev=c&hvlocint=9041110&hvlocphy=1010294&hvnetw=g&hvqmt=e&hvrand=6311385300851562426&hvtargid=kwd-297429021778&hydadcr=17613_1817768&keywords=computer+science+distilled&qid=1602170396&sr=8-1&tag=googhydr-21)

## Author(s)
* [Ayomide Oyekanmi](https://github.com/oyekanmiayo)