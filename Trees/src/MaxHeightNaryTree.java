import java.util.ArrayList;

class TreeNodes {
    Integer value;
    ArrayList<TreeNodes> children;

    TreeNodes(Integer value) {
        this.value = value;
        this.children = new ArrayList<>(3);
    }
}
public class MaxHeightNaryTree {
    static Integer find_height(TreeNodes root) {
        if(root == null) return 0;

        int max = 0;
        for(TreeNodes node: root.children){
            max = Math.max(max, find_height(node)+1);
        }
        return max;
    }
}
