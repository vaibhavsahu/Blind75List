public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int val){
        if(root == null) return true;
        if(root.val != val) return false;
        if(root.val == val && root.left == null && root.right == null) return true;
        return helper(root.left, val) && helper(root.right, val);
    }
}
