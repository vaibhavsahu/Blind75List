
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class UniqueBSTs2 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end){
        if(start > end) {
            return Collections.singletonList(null);
        }

        if(start == end) return List.of(new TreeNode(start));
        List<TreeNode> result = new ArrayList<>();
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubs = helper(start, i-1);
            List<TreeNode> rightSubs = helper(i+1, end);

            for(TreeNode left : leftSubs){
                for(TreeNode right: rightSubs){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        UniqueBSTs2 tree = new UniqueBSTs2();
        tree.generateTrees(3);
    }
}


