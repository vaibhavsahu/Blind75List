import java.util.*;

public class DFSTraversalGraph {
    static ArrayList<Integer> dfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        if(n == 1) return new ArrayList<>(List.of(0));

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            adjMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adjMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
        }
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!visited.contains(i)) dfs_traversalHelper(i, adjMap, visited, result);
        }
        return result;
    }

    static void dfs_traversalHelper(int start, Map<Integer, List<Integer>> adjMap,
                                    Set<Integer> visited, ArrayList<Integer> result){

        visited.add(start);
        result.add(start);

        for (int neighbor : adjMap.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                    result.add(neighbor);
                    visited.add(neighbor);
                    dfs_traversalHelper(neighbor, adjMap, visited, result);
                }
            }
        }
}
