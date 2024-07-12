import java.util.*;

public class CheckCompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 1));
        int expectedId = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                Pair<TreeNode, Integer> pair = queue.remove();
                int idx = pair.second;
                TreeNode node = pair.first;
                if(idx == expectedId) expectedId+=1;
                else return false;

                if(node.left != null) queue.add(new Pair<>(node.left, 2*idx));
                if(node.right != null) queue.add(new Pair<>(node.right, 2*idx+1));
            }
        }
        return true;
    }
}
