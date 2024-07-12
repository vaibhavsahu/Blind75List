import java.util.*;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 1));
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int count = queue.size();
            int first = 0;
            int last = 0;
            for(int i = 0; i < count; i++){
                Pair<TreeNode, Integer> pair = queue.remove();
                int idx = pair.second;
                TreeNode node = pair.first;

                if(node.left != null) queue.add(new Pair<>(node.left, 2*idx));
                if(node.right != null) queue.add(new Pair<>(node.right, 2*idx+1));

                last = idx;
                if(first == 0) first = idx;
            }
            result.add(last-first+1);
        }
        return result.stream().max(Comparator.naturalOrder()).get();
    }
}
