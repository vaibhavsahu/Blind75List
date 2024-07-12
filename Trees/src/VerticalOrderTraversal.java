import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        verticalOrderHelper(root, map, 0, 0);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(int key : keys){
            Comparator<Pair<Integer, Integer>> pairComparator = Comparator.comparing(Pair::getFirst);
            List<Pair<Integer, Integer>> list = map.get(key);
            list.sort(pairComparator);
            List<Integer> ans = new ArrayList<>();
            for(Pair<Integer, Integer> pair : list){
                ans.add(pair.second);
            }
            result.add(ans);
        }

        return result;
    }

    public void verticalOrderHelper(TreeNode root,
                                    Map<Integer, List<Pair<Integer, Integer>>> map,
                                    int row, int col){
        if(root != null){
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(new Pair<>(row, root.val));
        }

        if(root.left != null) verticalOrderHelper(root.left, map, row+1, col-1);
        if(root.right != null) verticalOrderHelper(root.right, map, row+1, col+1);
    }
}
