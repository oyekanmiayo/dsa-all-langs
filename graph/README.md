## Introduction
A graph is a non-linear data structure that consists of vertices and edges that link these vertices. A graph can be represented by the symbol **G(V,E)**, where V = vertices and E = edges.

Graphs are used to solve real-world problems that involve the representation of the problem space as a network e.g. telephone network, social networks, neural networks and so on. In the case of a social network, users can be represented as vertices and friendship between users can be represented using edges. You can generalize this examples to the other problems a graph can model.

There are two types of graphs: **Directed** and **Undirected**.

### Directed Graphs
In a directed graph, nodes are connected by directed edges – they only go in one direction. For example, in the image below, an edge connects node A and B, but the arrow head points towards B, so, we can only traverse from node A to node B – not in the opposite direction<sup>[1]()</sup>. 

<img src="images/directed-graph.png" height="200"/>

### Undirected Graphs
In an undirected graph the edges are bidirectional, with no direction associated with them. Hence, the graph can be traversed in either direction. For example, in the image below, the graph can be traversed from node A to node B as well as from node B to node A<sup>[1]()</sup>.

<img src="images/undirected-graph.png" height="200"/>

## Internals (Representation of Graphs)

## Internals (Graphs Traversals)

## Terminologies
1. **Indegree**: This is the number of incoming edges for a node in a graph. For an edge to be counted as incoming, the node must be the destination. For directed graphs, an edge is incoming for a node if the edge is directed at that node. For undirected graphs, the edge can be counted as incoming for the two linked node since, there is no direction associated with it.

1. **Outdegree**: This is the number of outgoing edges for a node in a graph.

## References
1. [What is a graph](https://www.educative.io/edpresso/what-is-a-graph-data-structure)
2. [Directed vs Undirected Graphs](https://www.educative.io/edpresso/directed-graphs-vs-undirected-graphs)
3. [Graphs](https://www.educative.io/edpresso/graphs-basics-representation-traversals-and-applications)