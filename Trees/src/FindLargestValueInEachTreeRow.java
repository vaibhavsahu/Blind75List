import java.util.*;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        averageOfLevelsHelper(root, result);
        return result;
    }

    public void averageOfLevelsHelper(TreeNode root, List<Integer> result){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.remove();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list.stream().max(Comparator.naturalOrder()).get());
        }
    }
}
