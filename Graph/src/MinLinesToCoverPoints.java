import java.util.*;

public class MinLinesToCoverPoints {
    public static int minimumLines(int[][] points) {
        Map<Double, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        Map<Double, Integer> slopeCountMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if(Math.abs(points[i][0] - points[j][0]) != 0.0){
                    double slope = (double) Math.abs(points[i][1] - points[j][1]) / Math.abs(points[i][0] - points[j][0]);
                    slopeCountMap.put(slope, slopeCountMap.getOrDefault(slope, 0)+1);
                    adjList.computeIfAbsent(slope, k -> new ArrayList<>()).add(new Pair<>(points[i][0], points[j][0]));
                    adjList.computeIfAbsent(slope, k -> new ArrayList<>()).add(new Pair<>(points[i][1], points[j][1]));
                }
            }
        }

        Set<Integer> visited = new HashSet<>();

        Comparator<Pair<Double, Integer>> comparator = Comparator.comparing(Pair::getFirst);

        PriorityQueue<Pair<Double, Integer>> minHeap =
                new PriorityQueue<>(comparator);

        minHeap.add(new Pair<>(0.0, 0));

        int totalCost = 0;

        while (visited.size() < points.length) {
            Pair<Double, Integer> pair = minHeap.remove();
            if (visited.contains(pair.second)) continue;

            totalCost += 1;
            visited.add(pair.second);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int [][] points = {{0,1},{2,3},{4,5},{4,3}};

        System.out.println(minimumLines(points));
    }
}
