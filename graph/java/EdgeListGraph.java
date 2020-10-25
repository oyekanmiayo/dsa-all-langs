/**
 * @author Ayomide Oyekanmi
 */
class EdgeListGraph {
    private List<int[]> graph;

    public EdgeListGraph() {
        graph = new ArrayList<>();
    }

    public static void main(){
        EdgeListGraph graph = new EdgeListGraph();
    }

    /**
     * Adds vertex to graph
     * 
     * @param vertex vertex to add to graph
     */
    public void addVertex(int vertex){
        // This  graph only contains edges, so it is not intuitive to add a vertex independently
    }

    /**
     * Returns true if the vertex exists, and false otherwise
     * 
     * @param v The vertex whose presence in the graph we want to ascertain
     * @return boolean true if vertex exists, and false otherwise
     */
    public boolean hasVertex(int v){
        for(int[] edge : graph){
            if (edge[0] == v || edge[1] == v){
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
    public void addEdge(int v1, int v2){
        // A extra check can go here to ensure there's no duplicate edge
        // We can traverse the List or convert it to a Set

        int[] newEdge = {v1, v2};
        graph.add(newEdge);
    }

    /**
     * Returns true if the edge exists, and false otherwise
     * 
     * @param v1 The first of the vertices we want to check if an edge exists for
     * @param v2 The second of the vertices we want to check if an edge exists for
     * @return boolean true if edge exists, and false otherwise
     */
    public boolean hasEdge(int v1, int v2){
        for(int[] edge : graph){
            if (edge[0] == v1 && edge[1] == v2){
                return true;
            }

            if (edge[0] == v2 && edge[1] == v1){
                return true;
            }
        }

        return false;
    }

    /**
     * Returns all the neighbours (or adjacent nodes) for given vertex
     * 
     * @param v Vertex whose neighbours we want to return
     * @return List<Integer> a list of neighbours for given vertex
     */
    public List<Integer> findNeighbours(int v){
        List<Integer> neighbours = new ArrayList<>();

        for(int[] edge : graph){
            if (edge[0] == v){
                neighbours.add(edge[1]);
            }

            if (edge[1] == v){
                neighbours.add(edge[0]);
            }
        }

        return neighbours;
    }
}