public class PathSum {
    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if(root == null) return false;
        return path_sumHelper(root, targetSum, 0);
    }

    Boolean path_sumHelper(BinaryTreeNode root, Integer k, int sumSofar){


        if(root == null) return false;

        if(root != null && root.left == null && root.right == null ){
            if(sumSofar+root.value == k) return true;
        }

        sumSofar += root.value;

        return path_sumHelper(root.left, k, sumSofar) || path_sumHelper(root.right, k, sumSofar);
    }
}
