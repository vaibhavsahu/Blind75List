import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EdgeToAdjList {
    static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            adjMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adjMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
        }

        for(int i = 0; i < n; i++){
            result.add(i, adjMap.get(i));
        }
        boolean [][] arr = new boolean[n][n];
        ArrayList<ArrayList<Boolean>> result1 = new ArrayList<>();

        for(ArrayList<Integer> list : edges){
            int i = list.get(0);
            int j = list.get(1);
            arr[i][j] = true;
            arr[j][i] = true;
        }

        for (boolean [] ar: arr) {
           ArrayList<Boolean> res = new ArrayList<>();
           for(boolean val: ar){
               res.add(val);
           }
           result1.add(res);
        }

        return result;
    }

}
