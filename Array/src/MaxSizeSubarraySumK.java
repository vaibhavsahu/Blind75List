import java.util.HashMap;
//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
public class MaxSizeSubarraySumK {
    public static int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;
        int right = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();
        while(right < nums.length){
            prefixSum += nums[right];

            if (prefixSum == k) {
                longestSubarray = right + 1;
            }

            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray,
                        right - indices.get(prefixSum - k));
            }

            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, right);
            }
            right++;
        }

        return longestSubarray;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int []{1,-1,5,-2,3}, 3));
    }
}
