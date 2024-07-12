import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTownJudge {
    static Integer find_town_judge(Integer n, ArrayList<ArrayList<Integer>> trust) {
       Map<Integer, List<Integer>> adjMap = new HashMap<>();

       for(ArrayList<Integer> relation: trust){
           adjMap.computeIfAbsent(relation.get(0), k -> new ArrayList<>()).add(relation.get(1));
       }
       int judge = Integer.MAX_VALUE;
       for(int i = 1; i <= n; i++){
           if(adjMap.getOrDefault(i, new ArrayList<>()).isEmpty()) judge = i;
       }

       if(adjMap.size() < n-1) return -1;

        return judge == Integer.MAX_VALUE ? -1 : judge;
    }

}
