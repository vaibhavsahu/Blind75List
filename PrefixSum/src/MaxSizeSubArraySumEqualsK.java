import java.util.HashMap;

public class MaxSizeSubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        var sum = 0;
        var result = 0;
        var maxLen = 0;

        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (var i = 0; i <  nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i-map.get(sum-k)+1);
            }
            map.put(sum, i+ 1);
        }

        return result;
    }
}
