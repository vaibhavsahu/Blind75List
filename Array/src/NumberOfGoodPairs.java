import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/number-of-good-pairs/description/
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int n = entry.getValue();
            count += (n*(n-1))/2;
        }
        return count;
    }
}
