import java.util.HashMap;
import java.util.Map;

public class TransposeDAG {
    static GraphNode create_transpose(GraphNode node){
        Map<GraphNode, GraphNode> transposed = new HashMap<>();
        dfs(node, transposed);
        return transposed.get(node);
    }

    static void dfs(GraphNode node, Map<GraphNode, GraphNode> transposed){
        if(transposed.containsKey(node)) return;

        GraphNode newNode = new GraphNode(node.value);
        transposed.put(node, newNode);

        for(GraphNode neighbor : node.neighbors){
            dfs(neighbor, transposed);
            transposed.get(neighbor).neighbors.add(newNode);
        }
    }
}
