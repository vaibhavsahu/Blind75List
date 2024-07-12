import java.util.*;


public class PathWithMinEffort {

    static int [] x = {-1, 1, 0, 0};
    static int [] y = {0, 0, -1, 1};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        var visited = new HashMap<Pair<Integer, Integer>, Integer>();
        var queue = new PriorityQueue<Pair<Integer, Pair<Integer, Integer>>>(
                                                                            Comparator.comparingInt(p -> p.first));

        queue.add(new Pair<>(0, new Pair<>(0,0)));

        while (!queue.isEmpty()){
            var entry = queue.remove();
            var effort = entry.first;
            var coordinate = entry.second;
            var indx = coordinate.first;
            var indy = coordinate.second;
            if(visited.containsKey(coordinate)) continue;

            visited.put(coordinate, effort);

            //goal
            if(indx == m-1 && indy == n-1) return visited.get(coordinate);

            for(int i = 0; i < x.length; i++){
                if(x[i]+indx >= m || indy+y[i] >= n || x[i]+indx < 0 || y[i]+indy < 0){
                    continue;
                } else {
                    var neighbor = new Pair<>(x[i]+indx,indy+y[i] );
                    if(!visited.containsKey(neighbor)){
                        int maxEffort = Math.max(visited.get(coordinate),
                                Math.abs(heights[indx][indy]-heights[neighbor.first][neighbor.second]));
                        queue.add(new Pair<>(maxEffort, neighbor));
                    }
                }
            }
        }
        return -1;
    }
}
