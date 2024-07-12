import java.util.LinkedList;
import java.util.Queue;

class Nodes {
    public int val;
    public Nodes left;
    public Nodes right;
    public Nodes next;

    public Nodes() {}

    public Nodes(int _val) {
        val = _val;
    }

    public Nodes(int _val, Nodes _left, Nodes _right, Nodes _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextrightPointer {
    public Nodes connect(Nodes root) {
        if(root == null) return null;

        Queue<Nodes> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            Nodes prev = null;
            for(int i = 0; i < count; i++){
                Nodes node = queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(prev != null) prev.next = node;
                prev = node;
            }
            //prev.next = queue.peek();
        }
        return root;
    }
}
