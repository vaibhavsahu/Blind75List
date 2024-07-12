import java.util.*;

public class ParallelCourses {
    static int timestamp = 0;
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for(int [] relation: relations){
            adjMap.computeIfAbsent(relation[0],
                    key -> new ArrayList<>()).add(relation[1]);
        }

        System.out.println(adjMap);

        boolean [] visited = new boolean[n+1];
        int [] departure = new int[n+1];

        Arrays.fill(departure, -1);

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(adjMap.containsKey(i) && dfs(i, adjMap, visited, departure, result)) {
                return -1;
            }
        }

        Collections.reverse(result);

        int [] maxPaths = new int[n+1];
        Arrays.fill(maxPaths, 1);
        for(int i = 1; i <= n && adjMap.containsKey(i); i++){
            //compute longest path upto node
                for(int neighbor: adjMap.getOrDefault(i, new ArrayList<>())){
                    if(neighbor != 0){
                        maxPaths[neighbor] = Math.max(maxPaths[neighbor], 1+maxPaths[i]);
                    }
                }
        }

        return Arrays.stream(maxPaths).max().getAsInt();
    }

    public boolean dfs(int node, Map<Integer, List<Integer>> adjMap, boolean [] visited, int [] departure, List<Integer> result ){
        visited[node] = true;

        for(int neighbor: adjMap.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){
                if(dfs(neighbor, adjMap, visited, departure, result)) return true;
            } else {
                if(departure[neighbor] == -1){
                    return true;
                }
            }
        }

        result.add(node);
        departure[node] = timestamp++;
        return false;
    }
}
