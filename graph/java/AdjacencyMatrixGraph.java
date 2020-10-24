/**
 * @author Ayomide Oyekanmi
 */
class AdjacencyMatrixGraph {
    List<List<Integer>> graph;

    public AdjacencyMatrixGraph(){
        graph = new ArrayList<>();
    }

    public boolean hasEdge(int v1, int v2){
        if (v1 >= graph.size()|| v2 >= graph.get(v1).size()){
            // throw exception
        }

        return graph.get(v1).get(v2) == 1;
    }

    /**
     * 
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