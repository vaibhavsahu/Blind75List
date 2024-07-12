import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//{
//"n": 5,
//"edges": [
//[0, 1],
//[0, 2],
//[1, 3],
//[3, 0],
//[3, 2],
//[4, 3],
//[4, 0]
//]
//}
//Output:
//
//1
public class EulerianCycle {
    static Boolean check_if_eulerian_cycle_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges){
            adjMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adjMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
        }

        int oddCount = 0;
        for(int i = 0; i < n; i++){
            int count = adjMap.getOrDefault(i, new ArrayList<>()).size();
            if(count % 2 != 0) oddCount++;
        }
        return oddCount <= 1;
    }

}
