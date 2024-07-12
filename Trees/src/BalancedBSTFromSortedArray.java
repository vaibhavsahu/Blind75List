import java.util.ArrayList;

public class BalancedBSTFromSortedArray {
    static BinaryTreeNode build_balanced_bst(ArrayList<Integer> a) {

        BinaryTreeNode root = build_balanced_bstHelper(a, 0, a.size()-1);
        return root;
    }

    static BinaryTreeNode build_balanced_bstHelper(ArrayList<Integer> a,
                                                   int start, int end){

        if(start > end) return null;

        int mid = start + (end-start)/2;


        BinaryTreeNode left = build_balanced_bstHelper(a, start, mid-1);
        BinaryTreeNode right = build_balanced_bstHelper(a, mid+1, end);
        BinaryTreeNode root = new BinaryTreeNode(a.get(mid));
        root.left = left;
        root.right = right;
        return root;

    }

}
