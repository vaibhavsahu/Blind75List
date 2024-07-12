public class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(TreeNode root) {
        if (root == null)  return 0;

        int leftSum = Math.max(gainFromSubtree(root.left), 0);
        int rightSum = Math.max(gainFromSubtree(root.right), 0);

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}
