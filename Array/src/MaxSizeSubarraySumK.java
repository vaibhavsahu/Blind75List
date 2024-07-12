import java.util.HashMap;
//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
public class MaxSizeSubarraySumK {
    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) maxLen = i+1;
            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int []{1,-1,5,-2,3}, 3));
    }
}
