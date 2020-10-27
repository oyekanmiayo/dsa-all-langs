import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayomide Oyekanmi
 * 
 * @note Deleting a vertex will be a complex operation with this implementation. It may be easier to just remove all edges 
 * that involve the vertex we wish to delete :)
 */
class AdjacencyMatrixGraph {
    private int[][] graph;

    public AdjacencyMatrixGraph(int vertexCount){
        graph = new int[vertexCount][vertexCount];
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph obj = new AdjacencyMatrixGraph(3);
        System.out.println(obj.hasVertex(0)); // True
        System.out.println(obj.hasVertex(1)); // True
        System.out.println(obj.hasVertex(2)); // True
        System.out.println(obj.hasVertex(3)); // False
        obj.addEdge(0, 1);
        System.out.println(obj.hasEdge(0, 1)); // True
        System.out.println(obj.hasEdge(1, 0)); // True
    }

    /**
     * Adds vertex to graph
     * 
     * @param v vertex to add to graph
     */
    public void addVertex(int v){
        // Don't use this implementation if you don't know number of vertices (a.k.a vertexCount) beforehand
        // It's too inefficient :')
    }
    
    /**
     * Returns true if the vertex exists, and false otherwise
     * 
     * @param v The vertex whose presence in the graph we want to ascertain
     * @return boolean true if vertex exists, and false otherwise
     */
    public boolean hasVertex(int v){
        return v < graph.length;
    }

    /**
     * Adds edge to graph
     * 
     * @param v1 The first of the adjacent vertices whose edge we want to add to the graph
     * @param v2 The second of the adjacent vertices whose edge we want to add to the graph
     */
    public void addEdge(int v1, int v2){
        if (v1 >= graph.length|| v2 >= graph.length){
            // throw exception
            return;
        }

        if (v1 >= graph[v2].length|| v2 >= graph[v1].length){
            // throw exception
            return;
        }

        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    /**
     * Returns true if the edge exists, and false otherwise
     * 
     * @param v1 The first of the vertices we want to check if an edge exists for
     * @param v2 The second of the vertices we want to check if an edge exists for
     * 
     * @return boolean true if edge exists, and false otherwise
     */
    public boolean hasEdge(int v1, int v2){
        if (v1 >= graph.length|| v2 >= graph.length){
            return false;
        }

        if (v1 >= graph[v2].length|| v2 >= graph[v1].length){
            return false;
        }

        return graph[v1][v2] == 1;
    }

    /**
     * Returns all the neighbours (or adjacent nodes) for given vertex
     * 
     * @param v Vertex whose neighbours we want to return
     * @return List<Integer> a list of neighbours for given vertex
     */
    public List<Integer> findNeighbours(int v){
        if (v >= graph.length){
            return new ArrayList<>();
        }

        List<Integer> neighbours = new ArrayList<>();
        int[] vertices = graph[v];
        for(int vertex : vertices){
            if(vertex == 1){
                neighbours.add(vertex);
            }
        }

        return neighbours;
    }
}