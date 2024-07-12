public class PathSumIII {
    int countPathsWithGivenSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        pathSumHelper(root, targetSum, 0);
        return countPathsWithGivenSum;
    }

    private void pathSumHelper(TreeNode root, int targetSum, int currSum) {

        if(currSum+ root.val == targetSum){
            countPathsWithGivenSum++;
            return;
        }
        if(currSum+root.val < targetSum){
            if(root.left != null) pathSumHelper(root, targetSum, currSum+ root.val);
            if(root.right != null) pathSumHelper(root, targetSum, currSum+root.val);
        }
    }
}
