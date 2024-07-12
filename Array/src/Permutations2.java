import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        permuteUniqueHelper(nums, list, result, map);
        return result;
    }

    public static void permuteUniqueHelper(int [] nums, List<Integer> list, List<List<Integer>> result, Map<Integer, Integer> map){
        if(list.size() == nums.length){
            List<Integer> ans = new ArrayList<>(list);
            System.out.println(ans);
            if(!result.contains(ans)) result.add(ans);
            return;
        } else {
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() > 0){
                    list.add(entry.getKey());
                    map.put(entry.getKey(), entry.getValue()-1);
                    permuteUniqueHelper(nums, list, result, map);
                    list.remove(list.size()-1);
                    map.put(entry.getKey(), entry.getValue()+1);
                }
            }
        }
    }
}
