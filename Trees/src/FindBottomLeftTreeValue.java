import java.util.ArrayList;
import java.util.List;


//        513. Find Bottom Left Tree Value
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        findBottomLeftValueHelper(root, 0, list);
        return list.get(list.size()-1);
    }
    //https://leetcode.com/problems/find-bottom-left-tree-value/

    public void findBottomLeftValueHelper(BinaryTreeNode root, int level, List<Integer> list){
        int mydepth = level+1;

        if(mydepth > list.size()) list.add(root.value);

        if(root.left == null && root.right == null) return;

        if(root.left != null) findBottomLeftValueHelper(root.left, mydepth, list);
        if(root.right != null) findBottomLeftValueHelper(root.right, mydepth, list);
    }
}
