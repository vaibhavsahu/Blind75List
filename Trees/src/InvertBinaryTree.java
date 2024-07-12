public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode p) {
        if(p == null) return ;

        TreeNode oldLeft = p.left;
        TreeNode oldRight = p.right;

        p.left = oldRight;
        p.right = oldLeft;

        if(p.left != null) invertTreeHelper(p.left);
        if(p.right != null) invertTreeHelper(p.right);
    }
}
