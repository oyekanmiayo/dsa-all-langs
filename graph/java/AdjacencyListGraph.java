/**
 * @author Ayomide Oyekanmi
 */
class AdjacencyListGraph<E> {
    Map<E, List<E>> graph;

    AdjacencyListGraph(){
        graph = new HashMap<>();
    }

    /**
     * Adds vertex to graph
     * 
     * @param v vertex to add to graph
     */
    public void addVertex(E v){
        if(graph.containsKey(v)){
            return;
        }

        List<E> list = new ArrayList<>();
        graph.put(v, new list);
    }

    /**
     * Returns true if the vertex exists, and false otherwise
     * 
     * @param v The vertex whose presence in the graph we want to ascertain
     * @return boolean true if vertex exists, and false otherwise
     */
    public boolean hasVertex(E v){
        return graph.containsKey(v);
    }

    /**
     * Adds edge to graph
     * 
     * @param v1 The first of the adjacent vertices whose edge we want to add to the graph
     * @param v2 The second of the adjacent vertices whose edge we want to add to the graph
     */
    public void addEdge(E v1, E v2){
        if(!graph.containsKey(v1)){
            List<E> list = new ArrayList<>();
            graph.put(v1, new list);
        }

        if(!graph.containsKey(v1)){
            List<E> list = new ArrayList<>();
            graph.put(v2, new list);
        }

        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    /**
     * Returns true if the edge exists, and false otherwise
     * 
     * @param v1 The first of the vertices we want to check if an edge exists for
     * @param v2 The second of the vertices we want to check if an edge exists for
     * 
     * @return boolean true if edge exists, and false otherwise
     */
    public boolean hasEdge(E v1, E v2){
        if(!graph.containsKey(v1)){
            return false;
        }
        
        List<E> neighbours = graph.get(v1);
        for(E neighbour : neighbours){
            if(v2.equals(neighbour)){
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
        if(!graph.containsKey(v)){
            return new ArrayList<>();
        }

        return graph.get(v);
    }
}