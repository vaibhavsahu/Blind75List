import java.util.ArrayList;

public class GraphNode {
    Integer value;
    ArrayList<GraphNode> neighbors;

    GraphNode(Integer value) {
        this.value = value;
        this.neighbors = new ArrayList(3);
    }
}