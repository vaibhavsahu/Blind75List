public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q != null && p.val == q.val){
            return isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
        }
        return false;
    }
}
