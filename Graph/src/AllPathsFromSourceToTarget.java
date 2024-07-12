import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0, result, list, graph, graph.length);
        return result;
    }

    public void helper(int node, List<List<Integer>> result, List<Integer> list,
                       int[][] graph, int n){
        if(node == n-1){
            list.add(node);
            result.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }

        list.add(node);
        for(int neighbor: graph[node]){
            helper(neighbor, result, list, graph, n);
        }
        if(!list.isEmpty()) list.removeLast();
    }
}
