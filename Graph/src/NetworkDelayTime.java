import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int []>> adjMap = new HashMap<>();

        for (int i = 1; i<= n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        for(int [] time: times){
            adjMap.computeIfAbsent(time[0], key -> new ArrayList<>())
                    .add(new int []{time[1], time[2]});
        }

        int [] captured = new int[n+1];
        Arrays.fill(captured, -1);
        int numCaptured = 0;
        int leastDistance = 0;

        var queue = new PriorityQueue<int []>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int []{0, k});

        //launch Dijkstra on k node
        while(!queue.isEmpty()){
            var entry = queue.remove();
            int node = entry[1];
            int dist = entry[0];

            if(captured[node] != -1) continue;

            captured[node] = dist;
            numCaptured++;
            leastDistance = dist;

            for(var entry1: adjMap.get(node)){
                int neighbor = entry1[0];
                int weight = entry1[1];
                if(captured[neighbor] == -1){
                    queue.add(new int []{weight+dist, neighbor});
                }
            }
        }

        return numCaptured == n ? leastDistance : -1;
    }
}
