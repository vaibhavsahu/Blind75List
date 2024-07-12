import java.util.*;

class MinCostConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<Pair<Integer,Integer>>> adjList = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < points.length; i++){
            for(int j = i+1 ; j < points.length; j++){
                int distance = Math.abs(points[i][0]-points[j][0])
                        +Math.abs(points[i][1]-points[j][1]);
                adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(new Pair<>(distance, j));
                adjList.computeIfAbsent(j, k -> new ArrayList<>()).add(new Pair<>(distance, i));
            }
        }

        Set<Integer> visited = new HashSet<>();

        Comparator<Pair<Integer, Integer>> comparator = Comparator.comparing(Pair::getFirst);

        PriorityQueue<Pair<Integer, Integer>> minHeap =
                new PriorityQueue<>(comparator);

        minHeap.add(new Pair<>(0, 0));

        int totalCost = 0;

        while(visited.size() < points.length){
            Pair<Integer, Integer> pair = minHeap.remove();
            if(visited.contains(pair.second)) continue;

            totalCost += pair.first;
            visited.add(pair.second);

            for(Pair<Integer, Integer> pair1: adjList.get(pair.second)){
                if(!visited.contains(pair1.second)) minHeap.add(pair1);
            }
        }
        return totalCost;
    }
}
