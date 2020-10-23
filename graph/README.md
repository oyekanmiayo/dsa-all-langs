## Introduction
A graph is a non-linear data structure that consists of vertices and edges that link these vertices. A graph can be represented by the symbol **G(V,E)**, where V = vertices and E = edges. We denote an edge connecting vertices u and v by the pair **(u,v)**<sup>[4](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>.

Graphs are used to solve real-world problems that involve the representation of the problem space as a network e.g. telephone network, social networks, neural networks and so on. In the case of a social network, users can be represented as vertices (or nodes) and friendship between users can be represented using edges. You can generalize this example to the other problems that a graph can model.

There are two types of graphs: **Directed** and **Undirected**.

### Directed Graphs
In a directed graph, nodes are connected by directed edges – they only go in one direction. For example, in the image below, an edge connects node A and B, but the arrow head points towards B, so, we can only traverse from node A to node B – not in the opposite direction<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>. 

<img src="images/directed-graph.png" height="75" width="200"/>

### Undirected Graphs
In an undirected graph the edges are bidirectional, with no direction associated with them. Hence, the graph can be traversed in either direction. For example, in the image below, the graph can be traversed from node A to node B as well as from node B to node A<sup>[1](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>.

<img src="images/undirected-graph.png" height="75" width="200"/>

## Internals (Representation of Graphs)
There are several ways to represent graphs, each with its advantages and disadvantages. Some situations or algorithms that we want to run with graphs as input, call for one representation, and others call for a different representation. Graphs are commonly represented in three ways:
1. Edge List
2. Adjacency Matrix
3. Adjacency List

We will use the graph below as an example to explain each representation

<img src="images/sample-graph.png" height="200" width="300"/>

### Edge List
One simple way to represent a graph is just a list, or array, of |E| edges, which we call an **edge list**. To represent an edge, we just have an array of two vertex numbers, or an array of objects containing the vertex numbers of the vertices that the edges are incident on<sup>[4](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>. The image below shows an **edge list** representation of the graph example.

<img src="images/edge-list.png" height="50" width="400"/>

#### Analysis
* The amount of space that this graph implementation uses is **O(|E|)**, where |E| = set of edges 
* Finding out if an edge exists will require searching through all available edges. The time complexity for  this is **O(|E|)**, where |E| = set of edges
* Finding out all the neighbours for an edge will also require searching  through all available edges. The time complexity for this is **O(|E|)**, where |E| = set of edges
* To find all the neighbours for an edge in a more efficient manner, we can sort the edge list. The time complexity for the last two operations will reduce  to **O(log|E|)**, where |E| = set of edges

### Adjacency Matrix
For a graph with |V| vertices, an **adjacency matrix** is a |V| × |V| matrix of 0s and 1s, where the entry in row<sub>i</sub> and column<sub>j</sub> is 1 if and only if the **edge (i,j)** is in the graph. The image below shows an **adjacency matrix** representation of the graph example.

<img src="images/adjacency-matrix.png" height="300" width="300"/>

#### Analysis
* The amount of space used for this implementation is **O(|V|<sup>2</sup>)**, where |V| = set of vertices. This implementation uses a lot of space that is especially inefficient if the graph has a small number of edges
* Finding out if an edge exists is very straight forward. Suppose the adjacency matrix above was called graph; to find out if an edge exists between i and j, we simply need to check if `graph[i][j] == 1`. The time complexity for this is **O(1)**
* Finding out all neighbours for a vertex will require searching |V| entries for that vertex. The time complexity for this is **O(|V|)**, where |V| = set of vertices

### Adjacency List
An **adjacency list** represents a graph as an array of lists. Each **index<sub>i</sub>** in this array represents a **vertex<sub>i</sub>** in the graph. Each **index<sub>i</sub>** contains a **list<sub>i</sub>** that contains all the nodes adjacent to **vertex<sub>i</sub>**. Whew, read that again if you need to (me sef I had to). The image below shows an **adjacency list** representation of the graph example.

<img src="images/adjacency-list.png" height="300" width="300"/>

#### Analysis
* The amount of space used for this implementation is **O(|V| + |E|)**, where |V| = set of vertices and |E| = set of edges 
* Finding out if an edge exists involved getting to the index of a vertex O(1) + traversing the list of neighbours at the index **O(d)**, where d = degree of current vertex. In the worst case d can be equal to |V| - 1 if a vertex is connected to all other vertices in the graph
* Finding all the neighbors for a vertex requires returning the list at the index of the vertex. This time complexity for this is **O(1)**

## Internals (Graphs Traversals)

## Terminologies
1. **Indegree**: This is the number of incoming edges for a node in a directed graph. For an edge to be counted as incoming, the node must be the destination. An edge is incoming for a node if the edge is directed at that node.

2. **Outdegree**: This is the number of outgoing edges for a node in a graph.

3. **Degree**: Indegree + Outdegree.

4. **Adjacent Nodes**: Two nodes are adjacent to each other if there is an edge linking them. Adjacent nodes are also called **neighbours**.

5. **Cycle**: A cycle exists in a graph when a node is seen twice in the same path.

6. **Weighted Graph**: A graph whose edges have weights<sup>[4](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>.

7. **Direct Acyclic Graph**: A directed graph that has no cycles.
## References
1. [What is a graph](https://www.educative.io/edpresso/what-is-a-graph-data-structure)
2. [Directed vs Undirected Graphs](https://www.educative.io/edpresso/directed-graphs-vs-undirected-graphs)
3. [Graphs: Educative](https://www.educative.io/edpresso/graphs-basics-representation-traversals-and-applications)
4. [Graphs: Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/)