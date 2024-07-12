import java.util.*;

public class CriticalConnectionsInNetwork {
    static int timestamp = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for(List<Integer> connection : connections){
            adjMap.computeIfAbsent(connection.get(0),
                    k -> new ArrayList<>()).add(connection.get(1));
            adjMap.computeIfAbsent(connection.get(1),
                    k -> new ArrayList<>()).add(connection.get(0));
        }
        int [] parent = new int[n];
        boolean [] visited = new boolean[n];
        int [] arrival = new int[n];
        int [] departure = new int[n];
        int [] lowestArrival = new int[n];
        Arrays.fill(lowestArrival, Integer.MAX_VALUE);
        dfs(0, arrival, departure, parent, visited, lowestArrival, adjMap, result);

        return result;
    }

    public int dfs(int node, int [] arrival, int [] departure,
                   int []parent, boolean [] visited,
                   int [] lowestArrival, Map<Integer, List<Integer>> adjMap
            ,List<List<Integer>> result){
        arrival[node]= timestamp++;
        visited[node] = true;
        lowestArrival[node] = arrival[node];
        for(int neighbor: adjMap.get(node)){
            if(!visited[neighbor]){
                parent[neighbor] = node;
                lowestArrival[node] = Math.min(lowestArrival[node],
                        dfs(neighbor, arrival, departure, parent, visited, lowestArrival, adjMap, result));
            } else{
                if(parent[node] != neighbor ){
                    lowestArrival[node] = Math.min(lowestArrival[node], arrival[neighbor]);
                }
            }
        }

        if(lowestArrival[node] == arrival[node] && node != 0){
            result.add(new ArrayList<>(List.of(node, parent[node])));
        }
        departure[node] = timestamp++;
        return lowestArrival[node];
    }
}
