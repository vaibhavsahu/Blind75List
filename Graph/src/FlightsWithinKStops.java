import java.util.Arrays;

public class FlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


         var dist = new int[n];
         Arrays.fill(dist, Integer.MAX_VALUE);
         dist[src] = 0;

         // Run only K+1 times since we want shortest distance in K hops
         for (var i = 0; i <= k; i++) {
             // Create a copy of dist vector.
             var temp = Arrays.copyOf(dist, n);
             for (var flight : flights) {
                 var from = flight[0];
                 var to = flight[1];
                 var currCost = flight[2];
                 if (dist[from] != Integer.MAX_VALUE) {
                     temp[to] = Math.min(temp[to],
                             dist[from] + currCost);
                 }
             }
             // Copy the temp vector into dist.
             dist = temp;
         }
         return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
