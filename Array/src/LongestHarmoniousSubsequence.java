import java.util.*;
import java.util.stream.Stream;

//https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {

        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());

        for (int num : nums) {
            Pair<Integer, Integer> pair1 = new Pair<>(num, num + 1);
            Pair<Integer, Integer> pair2 = new Pair<>(num-1, num);
            map.put(pair1, map.getOrDefault(pair1, 0) + 1);
            map.put(pair2, map.getOrDefault(pair2, 0) + 1);
        }

        int res = 0;

        for(Map.Entry< Pair<Integer, Integer>, Integer> entry: map.entrySet()){
            if(set.contains(entry.getKey().first)
                    && set.contains(entry.getKey().second)){
                res = Math.max(res, entry.getValue());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int []{1,3,2,2,5,2,3,7}));
    }
}
