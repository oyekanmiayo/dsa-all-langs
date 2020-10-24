/**
 * @author Ayomide Oyekanmi
 */
class AdjacencyMatrixGraph {
    List<List<Integer>> graph;

    public AdjacencyMatrixGraph(){
        graph = new ArrayList<>();
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
        if (v1 >= graph.size()|| v2 >= graph.get(v1).size()){
            // throw exception
        }

        return graph.get(v1).get(v2) == 1;
    }

    /**
     * Returns all the neighbours (or adjacent nodes) for given vertex
     * 
     * @param v Vertex whose neighbours we want to return
     * @return List<Integer> a list of neighbours for given vertex
     */
    public List<Integer> findNeighbours(int v){
        if (v >= graph.size()){
            // throw exception
        }

        List<Integer> neighbours = new ArrayList<>();
        List<Integer> vertices = graph.get(v);
        for(Integer vertex : vertices){
            if(vertex == 1){
                neighbours.add(vertex);
            }
        }

        return neighbours;
    }
}