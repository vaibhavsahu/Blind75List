import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] courses : edges) {
            adjList.computeIfAbsent(courses[0],
                    k -> new ArrayList<>()).add(courses[1]);
            adjList.computeIfAbsent(courses[1],
                    k -> new ArrayList<>()).add(courses[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited.contains(node)) return false;
            visited.add(node);
            if (adjList.containsKey(node)) {
                for (int neighbor : adjList.get(node)) {
                    if (!visited.contains(neighbor)) queue.add(neighbor);
                }
            }
        }
        return visited.size() == n;
    }
}
