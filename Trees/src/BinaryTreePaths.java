import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return  result;
        binaryTreePathsHelper(root, result, list);
        return result;
    }

    private void binaryTreePathsHelper(TreeNode root, List<String> result, List<Integer> list ) {
        list.add(root.val);
        if(root != null && root.left == null && root.right == null){
            String str = list.stream().map(String::valueOf).collect(Collectors.joining("->"));
            result.add(str);
        }
        if(root.left != null) {
            binaryTreePathsHelper(root.left, result, list);
        }
        if(root.right != null) {
            binaryTreePathsHelper(root.right, result, list);
        }
        list.remove(list.size()-1);
    }
}
