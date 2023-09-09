import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsequenceWithLimitedSum {
//https://leetcode.com/problems/longest-subsequence-with-limited-sum/
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            map.put(prefixSum , i);
        }

        int [] result = new int [queries.length];

        for(int i = 0; i < queries.length; i++){
            if(map.containsKey(queries[i])){
                result[i] = map.get(queries[i]);
            }
        }
        return result;
    }
}
