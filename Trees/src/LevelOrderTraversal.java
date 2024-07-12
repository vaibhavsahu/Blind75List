import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrderTraversal(BinaryTreeNode root){
        if(root == null) return new ArrayList<>();
        else {
            LinkedList<BinaryTreeNode> queue = new LinkedList<>();
            BinaryTreeNode curr = root;
            List<List<Integer>> result = new ArrayList<>();
            queue.add(curr);
            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                BinaryTreeNode node = queue.remove();
                list.add(node.value);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                result.add(new ArrayList<>(list));
            }
            return result;
        }
    }
}
