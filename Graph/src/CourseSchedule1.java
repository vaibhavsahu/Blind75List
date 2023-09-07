import java.util.*;

public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] courses : prerequisites) {
                adjList.computeIfAbsent(courses[1],
                        k -> new ArrayList<>()).add(courses[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (adjList.containsKey(i)) {
                for (int node : adjList.get(i)) indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int counter = 0;
        int[] topoSorted = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topoSorted[counter++] = node;
            if (adjList.containsKey(node)) {
                for (int neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) queue.add(neighbor);
                }
            }
        }
        return counter == numCourses;
    }
}
