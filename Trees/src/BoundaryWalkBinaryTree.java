import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryWalkBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null){
            return List.of(root.val);
        }
        List<List<Integer>> leftRightBoundaries = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        getLeftRightBoundaries(root, leftRightBoundaries);
        List<Integer> leaves = new ArrayList<>();
        dfs(root, leaves);
        result.addAll(leftRightBoundaries.get(0));
        result.addAll(leaves);
        result.addAll(leftRightBoundaries.get(1));
        return result;
    }

    public void getLeftRightBoundaries(TreeNode root, List<List<Integer>> leftRightBoundaries){
        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> rightBoundary = new ArrayList<>();
        if(root != null){
            leftBoundary.add(root.val);
        }

        if(root.left != null){
            TreeNode curr = root.left;
            while(curr != null){
                leftBoundary.add(curr.val);
                if(curr.left != null){
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            leftBoundary.remove(leftBoundary.size()-1);
        }

        if(root.right != null){
            TreeNode curr = root.right;
            while(curr != null){
                rightBoundary.add(curr.val);
                if(curr.right != null){
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            rightBoundary.remove(rightBoundary.size()-1);
        }

        Collections.reverse(rightBoundary);
        leftRightBoundaries.add(leftBoundary);
        leftRightBoundaries.add(rightBoundary);
    }

    public void dfs(TreeNode root, List<Integer> leaves){
        if(root != null && root.left == null && root.right == null){
            leaves.add(root.val);
        }
        if(root.left != null) dfs(root.left, leaves);
        if(root.right != null) dfs(root.right, leaves);
    }
}
