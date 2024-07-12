import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class MaxDepthNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int maxdepth = 0;
        for (Node it : root.children)
            maxdepth = Math.max(maxdepth, maxDepth(it));

        return maxdepth + 1 ;
    }
}
