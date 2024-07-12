import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree {
    int maxSum = Integer.MIN_VALUE;
    int minLevel = 0;
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        maxLevelSumHelper(root);
        return minLevel;
    }

    public void maxLevelSumHelper(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int currSum = 0;
            ++level;
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.remove();
                currSum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(currSum > maxSum){
                maxSum = currSum;
                minLevel = level;
            }
        }
    }
}
