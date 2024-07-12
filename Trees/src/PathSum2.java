import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

        if(root == null) return result;

    pathSumHelper(root, targetSum, 0, list, result);
        return result;
}

    public void pathSumHelper(TreeNode root, int targetSum, int currSum,
                              List<Integer> list, List<List<Integer>> result){

        list.add(root.val);
        if(currSum+root.val == targetSum && root != null
                && root.left == null && root.right == null){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
        }

        if(root.left != null) pathSumHelper(root.left, targetSum,
                currSum+root.val, list, result);
        if(root.right != null) pathSumHelper(root.right, targetSum,
                currSum+root.val, list, result);
        list.remove(list.size()-1);
    }
}
