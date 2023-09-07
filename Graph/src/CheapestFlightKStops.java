import java.util.*;

public class CheapestFlightKStops {


    //n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
    // src = 0, dst = 3, k = 1
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int []>> flightMap = new HashMap<>();

        for (int [] flight: flights){
            flightMap.computeIfAbsent(flight[0], value ->  new ArrayList<>())
                    .add(new int []{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int []> queue = new LinkedList<>();

        queue.add(new int[]{src, 0});
        int stops = 0;

        while( stops <= k && !queue.isEmpty()){
            int queueSize = queue.size();

            while (queueSize-- > 0){
                int [] temp = queue.remove();

                int node = temp[0];
                int distance = temp[1];

                if(!flightMap.containsKey(node)) continue;

                for (int[] flight : flightMap.get(node)) {
                    int neighbour = flight[0];
                    int price = flight[1];
                    if (price + distance >= dist[neighbour])  continue;
                    dist[neighbour] = price + distance;
                    queue.add(new int[] { neighbour, dist[neighbour] });
                }

            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src,
                                            int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Run only K+1 times since we want shortest distance in K hops
        for (int i = 0; i <= k; i++) {
            // Create a copy of dist vector.
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                if (dist[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]],
                            dist[flight[0]] + flight[2]);
                }
            }
            // Copy the temp vector into dist.
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
