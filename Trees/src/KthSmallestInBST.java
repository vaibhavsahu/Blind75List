import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
    static Integer kth_smallest_element(BinaryTreeNode root, Integer k) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();

        kth_smallest_elemenHelper(root, k, list);
        return list.get(k-1);
    }

    static void kth_smallest_elemenHelper(BinaryTreeNode root, int k, List<Integer> list){

        if(list.size() == k) return;

        if(root == null) return;

        if(root.left != null) kth_smallest_elemenHelper(root.left, k, list);
        list.add(root.value);
        if(root.right != null) kth_smallest_elemenHelper(root.right, k, list);
    }
}
