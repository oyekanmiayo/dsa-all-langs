/**
 * @author Ayomide Oyekanmi
 */
class AdjacencyListGraph<E> {
    Map<E, List<E>> graph;

    AdjacencyListGraph(){
        graph = new HashMap<>();
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
            // throw exception
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
            // throw exception
        }

        return graph.get(v);
    }
}