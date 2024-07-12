import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        int px = 0;
        int py = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                    if(node.left.val == x){
                        px = node.val;
                    }
                    if(node.left.val == y){
                        py = node.val;
                    }
                }
                if(node.right != null) {
                    queue.add(node.right);
                    if(node.right.val == x){
                        px = node.val;
                    }
                    if(node.right.val == y){
                        py = node.val;
                    }
                }
            }
            if(px != 0 || py != 0) {
                return px != 0 && py != 0 && px != py;
            }
        }
        return false;
    }
}
