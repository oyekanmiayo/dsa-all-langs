import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayomide Oyekanmi
 */
class EdgeListGraph<E> {
    private List<E[]> graph;

    public EdgeListGraph() {
        graph = new ArrayList<>();
    }

    public static void main(String[] args){
        EdgeListGraph<String> obj = new EdgeListGraph();
        obj.addEdge("Ayo", "Yuwa");
        System.out.println(obj.hasVertex("Ayo")); // True
        System.out.println(obj.hasVertex("Yuwa")); // True
        System.out.println(obj.hasEdge("Ayo", "Yuwa")); // True
        System.out.println(obj.hasEdge("Yuwa", "Ayo")); // True
        System.out.println(obj.findNeighbours("Ayo")); // Yuwa
        System.out.println(obj.findNeighbours("Yuwa")); // Ayo
    }

    /**
     * Adds vertex to graph
     * 
     * @param vertex vertex to add to graph
     */
    public void addVertex(E vertex){
        // This  graph only contains edges, so it is not intuitive to add a vertex independently
    }

    /**
     * Returns true if the vertex exists, and false otherwise
     * 
     * @param v The vertex whose presence in the graph we want to ascertain
     * @return boolean true if vertex exists, and false otherwise
     */
    public boolean hasVertex(E v){
        for(E[] edge : graph){
            if (v.equals(edge[0]) || v.equals(edge[1])){
                return true;
            }
        }

        return false;
    }

    /**
     * Adds edge to graph
     * 
     * @param v1 The first of the adjacent vertices whose edge we want to add to the graph
     * @param v2 The second of the adjacent vertices whose edge we want to add to the graph
     */
    public void addEdge(E v1, E v2){
        // A extra check can go here to ensure there's no duplicate edge
        // We can traverse the List or convert it to a Set

        Object[] arrObj = {v1, v2};
        E[] newEdge = (E[]) arrObj;
        graph.add(newEdge);
    }

    /**
     * Returns true if the edge exists, and false otherwise
     * 
     * @param v1 The first of the vertices we want to check if an edge exists for
     * @param v2 The second of the vertices we want to check if an edge exists for
     * @return boolean true if edge exists, and false otherwise
     */
    public boolean hasEdge(E v1, E v2){
        for(E[] edge : graph){
            if (v1.equals(edge[0]) && v2.equals(edge[1])){
                return true;
            }

            if (v2.equals(edge[0]) && v1.equals(edge[1])){
                return true;
            }
        }

        return false;
    }

    /**
     * Returns all the neighbours (or adjacent nodes) for given vertex
     * 
     * @param v Vertex whose neighbours we want to return
     * @return List<E> a list of neighbours for given vertex
     */
    public List<E> findNeighbours(E v){
        List<E> neighbours = new ArrayList<>();

        for(E[] edge : graph){
            if (v.equals(edge[0])){
                neighbours.add(edge[1]);
            }

            if (v.equals(edge[1])){
                neighbours.add(edge[0]);
            }
        }

        return neighbours;
    }
}