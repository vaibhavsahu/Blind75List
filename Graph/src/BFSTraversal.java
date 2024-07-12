import java.util.*;

//{
//"n": 6,
//"edges": [
//[0, 1],
//[0, 2],
//[0, 4],
//[2, 3]
//]
//}
public class BFSTraversal {
    static ArrayList<Integer> bfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        if(n == 1) return new ArrayList<>(List.of(0));

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            adjMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adjMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
        }
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!visited.contains(i)) bfs_traversalHelper(i, adjMap, visited, result);
        }
        return result;
    }

    static void bfs_traversalHelper(int start,Map<Integer, List<Integer>> adjMap,
                                        Set<Integer> visited,  ArrayList<Integer> result){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        result.add(start);

        while(!queue.isEmpty()){
            int vertex = queue.remove();
            for(int neighbor: adjMap.getOrDefault(vertex, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    result.add(neighbor);
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
