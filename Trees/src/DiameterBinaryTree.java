public class DiameterBinaryTree {

    int diameter = 0;
    public int diameterBinaryTree(BinaryTreeNode root){
         diameterBinaryTreeHelper(root);
         return diameter;
    }

    public int diameterBinaryTreeHelper(BinaryTreeNode root){
        if(root == null)  return 0;

        int leftDiameter = diameterBinaryTreeHelper(root.left);
        int rightDiameter = diameterBinaryTreeHelper(root.right);

        diameter = Math.max(diameter, leftDiameter+rightDiameter);

        return Math.max(leftDiameter, rightDiameter)+1;
    }
}
