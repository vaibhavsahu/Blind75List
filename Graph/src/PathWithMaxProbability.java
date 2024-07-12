import java.util.*;

public class PathWithMaxProbability {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        var adjMap = new HashMap<Integer, List<Pair<Integer, Double>>>();

        for(int i = 0; i < edges.length; i++){
            adjMap.computeIfAbsent(edges[i][0],
                            key -> new ArrayList<>())
                    .add(new Pair<>(edges[i][1], succProb[i]));
            adjMap.computeIfAbsent(edges[i][1],
                            key -> new ArrayList<>())
                    .add(new Pair<>(edges[i][0], succProb[i]));
        }
        double [] captured = new double[n];
        Arrays.fill(captured, -1);

        var queue = new PriorityQueue<Pair<Double, Integer>>((a, b) -> -Double.compare(a.first, b.first));
        queue.add(new Pair<>(1.0, start_node));

        //launch Dijkstra on k node
        while(!queue.isEmpty()){
            var entry = queue.remove();
            int node = entry.second;
            double dist = entry.first;

            if(captured[node] != -1.0) continue;

            captured[node] = dist;
            if(node == end_node) return captured[node];
            for(var entry1: adjMap.get(node)){
                int neighbor = entry1.first;
                double weight = entry1.second;
                if(captured[neighbor] == -1.0){
                    queue.add(new Pair<>(weight*dist, neighbor));
                }
            }
        }

        return captured[end_node] == -1.0 ? 0.0 : captured[end_node];
    }
}
