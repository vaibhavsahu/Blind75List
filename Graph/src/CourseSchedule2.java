import java.util.*;

public class CourseSchedule2 {

    public static int [] numOfCourses(int numCourses, int [][] prerequisites){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
       int [] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int [] courses = prerequisites[i];
            adjList.computeIfAbsent(courses[1],
                        k -> new ArrayList<>()).add(courses[0]);
            indegree[courses[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        int counter = 0;
        int [] topoSorted = new int[numCourses];
        while (!queue.isEmpty()){
            int node = queue.remove();
            topoSorted[counter++] = node;
            if(adjList.containsKey(node)){
                for (int neighbor: adjList.get(node)) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) queue.add(neighbor);
                }
            }
        }
    return counter == topoSorted.length ? topoSorted : new int[0];
    }

    public static void main(String[] args) {
        int [][] prereqs= {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(numOfCourses(4, prereqs)));
    }
}
