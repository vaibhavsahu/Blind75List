public class isValidBST {
    long max = Long.MAX_VALUE;
    long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, min, max);
    }

    public boolean isValidBSTHelper(TreeNode root, long min, long max){
        if(root == null ) return true;

        if(root.val >= max || root.val <= min) return false;

        return isValidBSTHelper(root.left , min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}
