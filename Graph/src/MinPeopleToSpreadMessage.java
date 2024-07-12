import java.util.*;

public class MinPeopleToSpreadMessage {
     static int timestamp = 0;
     static int numScc = 0;
    public static void main(String[] args) {
        //A follows B, B follows C, C follows D,

        var edges = new int [][]{
                {0, 1, 0, 0}, {0, 0, 1, 0}, {0,0,0,1}, {0,0,0,0}
        };
        var adjMap = new HashMap<Integer, List<Integer>>();

        for(var edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        var visited = new int[4];
        Arrays.fill(visited, -1);
        var departure = new int[4];
        Arrays.fill(departure, -1);
        var arrival = new int[4];
        Arrays.fill(arrival, -1);
        var lowestArrival = new int[4];
        var stack = new Stack<Integer>();
        var sccId = new int[4];


        for (var i = 0; i < 4; i++) {
            if(visited[i] == -1) {
                dfs(i, visited, departure, arrival, lowestArrival, adjMap, stack, sccId);
            }
        }
        System.out.println(Arrays.toString(sccId));

    }

    public static int dfs(int node, int [] visited, int [] departure,
                    int [] arrival, int [] lowestArrival,
                    HashMap<Integer, List<Integer>> adjMap, Stack<Integer> stack, int [] sccId){
        timestamp++;
        visited[node] = 1;
        arrival[node] = timestamp;
        lowestArrival[node] = arrival[node];
        stack.push(node);

        for(var neighbor : adjMap.getOrDefault(node, new ArrayList<>())){
            if(visited[neighbor] == -1){
                lowestArrival[node] = Math.min(lowestArrival[node], dfs(neighbor, visited, departure, arrival,
                        lowestArrival, adjMap, stack, sccId));
            } else {
                if(departure[neighbor] == -1 || sccId[neighbor] == -1){
                    lowestArrival[node] = Math.min(lowestArrival[node], arrival[neighbor]);
                }
            }
        }

        if(lowestArrival[node] == arrival[node]){

            var set = new HashSet<Integer>();
            var top = stack.pop();
            while (top != node){
                set.add(top);
                top = stack.pop();
            }
            set.add(top);
        }


        departure[node] = timestamp++;
        return lowestArrival[node];
    }
}
