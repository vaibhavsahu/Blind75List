import java.util.*;

public class CityWithSmallestNumberOfNeighborsWithinThresholdDistance {

    int globlaMin = Integer.MAX_VALUE;
    int bestCity = -1;
    //if a graph is sparse
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Pair<Integer, Integer>>> adjMap = new HashMap<>();

        for (var edge : edges) {
            adjMap.computeIfAbsent(edge[0],
                    key -> new ArrayList<>()).add(
                    new Pair<>(edge[1],edge[2]));
            adjMap.computeIfAbsent(edge[1],
                    key -> new ArrayList<>()).add(
                    new Pair<>(edge[0],edge[2]));
        }

        for(int i = 0; i < n; i++){
            dijkstra(i, adjMap, distanceThreshold);
        }

        return bestCity;
    }

    public void dijkstra(int city,  Map<Integer,
            List<Pair<Integer, Integer>>> adjMap, int distanceThreshold){
        var queue =
                new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparingInt(a -> a.first));

        queue.add(new Pair<>(0, city));
        Map<Integer, Integer> captured = new HashMap<>();

        while (!queue.isEmpty()){
            var entry = queue.remove();
            var distance = entry.first;
            var node = entry.second;

            if(captured.containsKey(node)) continue;

            captured.put(node, distance);

            if(distance > distanceThreshold) break;

            for(var neighbor:
                    adjMap.getOrDefault(node, new ArrayList<>())){
                if(!captured.containsKey(neighbor.first)){
                    queue.add(new Pair<>(
                            distance+neighbor.second, neighbor.first));
                }
            }
        }

        if(captured.size() <= globlaMin) {
            bestCity = city;
            globlaMin = captured.size();
        }
    }

    public int findTheCityFloydWarshall(int n, int[][] edges, int distanceThreshold) {

        int [][] result = new int[n][n];
        for (int[] row : result)
            Arrays.fill(row, 10001);

        for(int i = 0; i < n; i++){
            result[i][i] = 0;
        }

        for (int [] edge: edges){
            result[edge[0]][edge[1]] = edge[2];
            result[edge[1]][edge[0]] = edge[2];
        }

        for (int i = 0; i < n; i++){
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    result[row][col] = Math.min(result[row][col], result[row][i] + result[i][col]);
                }
            }
        }

        for (int row = 0; row < n; row++) {
            int score = 0;
            for(int col = 0; col < n; col++){
                if(result[row][col] <= distanceThreshold) score++;
            }
            if(score <= globlaMin){
                globlaMin = score;
                bestCity = row;
            }
        }
        return bestCity;
    }

}
