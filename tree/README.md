## Introduction
Let's begin with some definitions of a tree:
- A tree is a nonlinear hierarchical data structure that consists of nodes connected by edges [^programiz-trees]
- A tree is a connected, acyclic, undirected graph

Like LinkedLists, the Tree employs memory cells that do not need to be contiguous in physical memory to store objects [^cs-distilled];this means that each cell contains a pointer to other cells, therefore there's no need for them to be adjacent in memory.
However, unlike LinkedLists, instead of pointing to a "next" cell linearly (i.e. with a linear abstraction), Trees point to the next cells hierarchically (i.e. with a hierarchical abstraction). Thinking about hierarchical data helps to visualize trees well. 
See below a diagram representing a sample hierarchy in Company X.

<img alt="A sample company hierarchy modeling a tree" src="tree/images/tree-hierarchy.png" height="350" width="500">

## Important Terminologies

1. Node: This is also called a cell. An entity that contains a value and pointers to zero or more child nodes.
2. Edge: If a node points to another node, then we say that there is an edge between both nodes.
3. Root: The topmost node of a tree. In the example image above, the root is the CEO node.
4. Parent: If an edge exists between two nodes, the node the edge originates from is called the parent.
5. Child: If an edge exists between two nodes, the node the edge terminates at is called the child.
6. Leaf: A node is a leaf if it has no children.
7. Path: The path between two nodes is the set of all nodes and edges that can lead from the first to the second node. 
See an [example](../images/tree-path.png) below showing a path from node A to node B.
8. Level (of a Node):  This is also called depth. The level of a node is the number of edges from the root node to the said node[^andrew-cmu].
See a [diagram](../images/tree-level.png) showing nodes and their levels.
9. Height (of a Node): The height of a node is the number of edges on the longest path from that node to the farthest leaf it can reach. 
In this [diagram](../images/tree-height.png), take note of the height of each node.
10. Height (of a Tree): The height of a tree is the distance from the root node to the deepest leaf. See root node in this [diagram]().

#### Types of Trees
* Binary Tree: A binary tree is one in which each node has at most 2 children,
* N-ary: A tree where each node can have a varied number of children. An example of an N-ary tree is a Trie.
* Binary Search Tree: A binary tree in which for every node, the value of each child node on its left subtree is less than its value, 
and the value of each child node on its right subtree is greater than its value.

[^programiz-trees]: https://www.programiz.com/dsa/trees
[^cs-distilled]: https://code.energy/computer-science-distilled/#get-your-copy
[^andrew-cmu]: https://www.andrew.cmu.edu/course/15-121/lectures/Trees/trees.html