import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EulerianPath {
    static Boolean check_if_eulerian_path_exists(Integer n, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            adjMap.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            adjMap.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0));
        }

        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            int count = adjMap.getOrDefault(i, new ArrayList<>()).size();
            if (count % 2 != 0) oddCount++;
        }
        return oddCount <= 2;
    }
}
