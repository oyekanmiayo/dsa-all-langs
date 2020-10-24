/**
 * @author Ayomide Oyekanmi
 */
class AdjacencyListGraph<E> {
    Map<E, List<E>> graph;

    AdjacencyListGraph(){
        graph = new HashMap<>();
    }

    /**
     * 
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
     * 
     */
    public List<E> findNeighbours(int v){
        if(!graph.containsKey(v)){
            // throw exception
        }

        return graph.get(v);
    }
}