import java.util.ArrayList;
import java.util.List;

public class MinDepthBinaryTree {
    public int minDepth(BinaryTreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left)+1;
        int right = minDepth(root.right)+1;

        if(root.left == null){
            return right;
        }
        if(root.right == null){
            return left;
        }
        List<Integer> list = new ArrayList<>();
        list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        return Math.min(left,right);
    }


}
