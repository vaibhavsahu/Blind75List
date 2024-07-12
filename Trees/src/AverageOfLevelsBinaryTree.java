import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/1093386927/
    public List<Double> averageOfLevels(BinaryTreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        averageOfLevelsHelper(root, result);
        return result;
    }

    public void averageOfLevelsHelper(BinaryTreeNode root, List<Double> result){
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                BinaryTreeNode node = queue.remove();
                list.add(node.value);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list.stream().mapToInt(Integer::intValue)
                    .average().getAsDouble());
        }
    }
}
