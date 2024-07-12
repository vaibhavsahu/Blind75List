import java.util.LinkedList;
import java.util.Queue;

public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        if(depth == 1){
            TreeNode leftNode = new TreeNode(val);
           leftNode.left = root;
           root = leftNode;
        return root;
        }
        while(!queue.isEmpty()){
            int count = queue.size();
            ++level;
            for(int i = 0; i < count; i++){
                TreeNode node = queue.remove();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(level == depth-1){
                    TreeNode leftNode = new TreeNode(val);
                    TreeNode rightNode = new TreeNode(val);

                    leftNode.left = node.left;
                    rightNode.right = node.right;
                    node.left = leftNode;
                    node.right = rightNode;
                }
            }
        }

        return root;
    }
}
