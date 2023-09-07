//
//class Pair<U, V>{
//    U dest;
//    V distance;
//
//    public Pair(U dest, V distance){
//        this.dest = dest;
//        this.distance = distance;
//    }
//}

import java.util.*;

public class MinScoreCitiesPath {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair<Integer, Integer>>> distanceMap = new HashMap<>();

        for(int [] road: roads){
            distanceMap.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new Pair<>(road[1], road[2]));
            distanceMap.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new Pair<>(road[0], road[2]));
        }

        int [] resDistance = new int [1];

        resDistance[0] = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();

        dfs(1, visited, distanceMap, resDistance);

        return resDistance[0];
    }

    public void dfs(int start, Set<Integer> visited, Map<Integer,
            List<Pair<Integer, Integer>>> distanceMap, int [] resDistance){
        if(visited.contains(start)){
            return;
        }

        visited.add(start);

        for(Pair<Integer, Integer> pair : distanceMap.get(start)){
            resDistance[0] = Math.min(resDistance[0], pair.second);
            dfs(pair.first, visited, distanceMap, resDistance);
        }

    }
}
