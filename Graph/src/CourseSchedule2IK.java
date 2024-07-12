import java.util.*;


public class CourseSchedule2IK {
    static ArrayList<Integer> course_schedule(Integer n, ArrayList<ArrayList<Integer>> courses) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(ArrayList<Integer> list: courses){
            adjMap.computeIfAbsent(list.get(0), k -> new ArrayList<>()).add(list.get(1));
        }

        boolean [] visited = new boolean[n];
        int [] arr = new int[n];
        int [] dep = new int[n];
        int [] parent = new int[n];
        Arrays.fill(arr, -1);
        Arrays.fill(dep, -1);
        Arrays.fill(parent, -1);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if(dfs(i, adjMap, visited, arr, dep, parent, result)) return new ArrayList<>(List.of(-1));
            }
        }
        return result.size() < n ? new ArrayList<>(List.of(-1)): result;
    }

    private static boolean dfs(int start, Map<Integer, List<Integer>> adjMap,
                               boolean[] visited, int[] arr, int[] dep,
                               int [] parent, ArrayList<Integer> result) {

        visited[start] = true;
        arr[start]++;

        for(int neighbor: adjMap.getOrDefault(start, new ArrayList<>())){
            if(!visited[neighbor]){
                parent[neighbor] = start;
                boolean res = dfs(neighbor, adjMap, visited, arr, dep, parent, result);
                if(res) return true;
            } else {
                if(parent[neighbor] != start && dep[neighbor] == -1) return true; //cycle found
            }
        }
        dep[start]++;
        result.add(start);
        return false;
    }

}
