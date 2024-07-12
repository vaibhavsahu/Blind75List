import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        zigzag_level_order_traversalHelper(root, result);
        return result;
    }

    static void zigzag_level_order_traversalHelper(BinaryTreeNode root,
                                                   List<List<Integer>> result ){
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()){
            int count = queue.size();
            Integer [] arr = new Integer[count];
            for(int i = 0; i < count; i++){
                BinaryTreeNode node = queue.remove();
                if(node != null){
                    int index = isLeftToRight ? i : (count - 1 - i);
                    arr[index] = node.value;
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
            }
            List<Integer> temp = Arrays.stream(arr).toList();
            result.add(temp);
            isLeftToRight = !isLeftToRight;

        }
    }
}
