import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        var sum = 0;
        var result = 0;

        // There are k mod groups 0...k-1.
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (var num : nums) {
            sum += num;

            if (map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
