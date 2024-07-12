public class MaxDepthBinaryTree {
    public int maxDepth(BinaryTreeNode root) {
        if(root == null ) return 0;
//https://leetcode.com/problems/maximum-depth-of-binary-tree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
}
