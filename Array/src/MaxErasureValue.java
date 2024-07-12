import java.util.HashMap;
import java.util.Map;

public class MaxErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        while(right < nums.length){
            currSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(left <= right && map.size() < right-left+1){
                map.put(nums[left], map.get(nums[left])-1);
                currSum -= nums[left];
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            maxSum = Math.max(maxSum, currSum);
            right++;
        }
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
