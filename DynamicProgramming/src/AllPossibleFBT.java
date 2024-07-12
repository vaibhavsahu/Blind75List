import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) return new ArrayList<>();
        return helper(n);
    }

    public List<TreeNode> helper(int k){
        if(k == 0) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(null);
            return temp;
        }

        if(k == 1) return List.of(new TreeNode(0));
        List<TreeNode> result = new ArrayList<>();
        for(int i = 2; i < k; i++){
            List<TreeNode> leftSubs = helper(i-1);
            List<TreeNode> rightSubs = helper(k-i);

            for(TreeNode left : leftSubs){
                for(TreeNode right: rightSubs){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

