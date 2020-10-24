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

Some operations we can perform on a graph include:
* `addVertex(vertex)`
* `addEdge(vertex1, vertex2)`
* `findEdge(vertex1, vertex2)`
* `findNeighbours(vertex)`

## Internals : Representation of Graphs
There are several ways to represent graphs, each with its advantages and disadvantages. Some situations or algorithms that we want to run with graphs as input, call for one representation, and others call for a different representation. Graphs are commonly represented in three ways:
1. Edge List
2. Adjacency Matrix
3. Adjacency List

We will use the graph below as an example to explain each representation

<img src="images/sample-graph.png" height="200" width="300"/>

### Edge List
One simple way to represent a graph is just a list, or array, of |E| edges, which we call an **edge list**. To represent an edge, we just have an array of two vertex numbers, or an array of objects containing the vertex numbers of the vertices that the edges are incident on<sup>[4](https://github.com/oyekanmiayo/data-structures-all-langs/tree/main/graph#references)</sup>. The image below shows an **edge list** representation of the graph example. 

<img src="images/edge-list.png" height="50" width="400"/>

The amount of space that this graph implementation uses is **O(|E|)**, where |E| = set of edges.

#### Operations
1. **`findEdge(vertex1, vertex2)`**
    ```
    # Traverese array of edges and compare each one until edge is found
    def findEdge(v1, v2):
        for edge in edges:
            if edge[0] = v1 && edge[1] = v2
                return edge

        return nil
    ```

    **Time Complexity**: Linear Time or **O(|E|)**, where **|E|** = array or set of edges
    | Array Traversal        | Worst Case for `findEdge(vertex1, vertex2)` |
    |------------------------|---------------------------------------------|
    | Linear Time / O(\|E\|) | Linear Time / O(\|E\|)                      |

    **Space  Complexity**: No extra space is used in this method. Space used  to store all  edges. Constant Space or **O(1)**
    | Worst Case for `findEdge(vertex1, vertex2)` |
    |---------------------------------------------|
    | Constant Space / O(1)                       |

2. **`findNeighbours(vertex)`**
    ```
    # Traverse array of edges and store all edges for given vertex
    def findEdge(v):
        neighbours = []
        for edge in edges:
            if edge[0] = v or edge[1] = v
                neighbours.append(edge)

        return neighbours
    ```

    **Time Complexity**: Linear Time or **O(|E|)**, where **|E|** = array or set of edges
    | Array Traversal        | Worst Case for `findNeighbours(vertex)` |
    |------------------------|---------------------------------------------|
    | Linear Time / O(\|E\|) | Linear Time / O(\|E\|)                      |

    **Space  Complexity**: Space used  to store all neighbours. Linear Space or **O(|E|)**, where **|E|** = array or set of edges
    | Array of Neighbours     | Worst Case for `findNeighbours(vertex)` |
    |-------------------------|-----------------------------------------|
    | Linear Space / O(\|E\|) | Linear Space / O(\|E\|)                 |


#### Additional Notes
* To find edge and all the neighbours for an edge in a more efficient manner, we can sort the edge list. The time complexity for  `findEdge(vertex1, vertex2)` and `findNeighbours(vertex)` will reduce  to **O(log|E|)**, where |E| = set of edges

### Adjacency Matrix
For a graph with |V| vertices, an **adjacency matrix** is a |V| × |V| matrix of 0s and 1s, where the entry in row<sub>i</sub> and column<sub>j</sub> is 1 if and only if the **edge (i,j)** is in the graph. The image below shows an **adjacency matrix** representation of the graph example.

<img src="images/adjacency-matrix.png" height="300" width="300"/>

The amount of space used for this implementation is **O(|V|<sup>2</sup>)**, where |V| = set of vertices. This implementation uses a lot of space that is especially inefficient if the graph has a small number of edges.

#### Operations
1. **`findEdge(vertex1, vertex2)`**
    ```
    # Constant time lookup in 2D array
    # Suppose 2-D array shown in image above is called `graph`
    def findEdge(v1, v2):
        return graph[v1][v2]
    ```

    **Time Complexity**: Constant Time or **O(1)**
    | 2-D Array Lookup     | Worst Case for `findEdge(vertex1, vertex2)` |
    |----------------------|---------------------------------------------|
    | Constant Time / O(1) | Constant Time / O(1)                        |

    **Space  Complexity**: No extra space is used in this method. Space used  to store all  edges. Constant Space or **O(1)**
    | Worst Case for `findEdge(vertex1, vertex2)` |
    |---------------------------------------------|
    | Constant Space / O(1)                       |

2. **`findNeighbours(vertex)`**
    ```
    # Traverse row at the vertex's column index in the 2-D array
    # Suppose 2-D array shown in image above is called `graph`
    def findNeighbours(vertex):
        vertexRow = graph[vertex]
        neighbours = []
        for vertex in vertexRow:
            if vertex == 1
                neighbours.append(vertex)

        return neighbours
    ```

    **Time Complexity**: Qua Time or **O(|E|)**, where **|E|** = array or set of edges
    | Array Traversal        | Worst Case for `findNeighbours(vertex)` |
    |------------------------|---------------------------------------------|
    | Linear Time / O(\|E\|) | Linear Time / O(\|E\|)                      |

    **Space  Complexity**: Space used  to store all neighbours. Linear Space or **O(|E|)**, where **|E|** = array or set of edges
    | Array of Neighbours     | Worst Case for `findNeighbours(vertex)` |
    |-------------------------|-----------------------------------------|
    | Linear Space / O(\|E\|) | Linear Space / O(\|E\|)                 |


### Adjacency List
An **adjacency list** represents a graph as an array of lists. Each **index<sub>i</sub>** in this array represents a **vertex<sub>i</sub>** in the graph. Each **index<sub>i</sub>** contains a **list<sub>i</sub>** that contains all the nodes adjacent to **vertex<sub>i</sub>**. Whew, read that again if you need to (me sef I had to). The image below shows an **adjacency list** representation of the graph example.

<img src="images/adjacency-list.png" height="300" width="300"/>

#### Analysis
* The amount of space used for this implementation is **O(|V| + |E|)**, where |V| = set of vertices and |E| = set of edges 
* Finding out if an edge exists involved getting to the index of a vertex O(1) + traversing the list of neighbours at the index **O(d)**, where d = degree of current vertex. In the worst case d can be equal to |V| - 1 if a vertex is connected to all other vertices in the graph
* Finding all the neighbors for a vertex requires returning the list at the index of the vertex. This time complexity for this is **O(1)**

(Make a note here about how graphs don't usually come pre-packaged in a language like other data structures.)

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
3. [Graphs: Educative[dot]io](https://www.educative.io/edpresso/graphs-basics-representation-traversals-and-applications)
4. [Graphs: Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/)