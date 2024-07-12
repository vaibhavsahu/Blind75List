import java.util.*;

public class CourseScheduleWithArrivalDepartureTechnique {
    static Boolean can_be_completed(Integer n, ArrayList<Integer> a, ArrayList<Integer> b) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            adjMap.computeIfAbsent(b.get(i), k -> new ArrayList<>()).add(a.get(i));
        }

        int [] visited = new int[n];
        int [] arr = new int[n];
        int [] dep = new int[n];
        Arrays.fill(arr, -1);
        Arrays.fill(dep, -1);
        Arrays.fill(visited, -1);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(dfs(i, visited, arr, dep, result, adjMap)) return false;
        }
      //  result.reversed();
        return result.size() < n;
    }

    static boolean dfs(int start, int [] visited, int [] arr, int [] dep,
                       ArrayList<Integer> result, Map<Integer, List<Integer>> adjMap){
        visited[start] = 1;
        arr[start]++;
        for(int neighbor: adjMap.getOrDefault(start, new ArrayList<>())){
            if(visited[neighbor] == -1){
                boolean res = dfs(neighbor, visited, arr, dep, result, adjMap);
                if(res) return true;
            } else {
               if(dep[neighbor] == -1) return true;
            }
        }
        dep[start]++;
        result.add(start);
        return false;
    }

}
