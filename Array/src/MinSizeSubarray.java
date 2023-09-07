/*
Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal
        length under the problem constraint.
*/

public class MinSizeSubarray {

    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            currSum += nums[right];
            while (currSum >= target) {
                minLen = Math.min(minLen, right-left+1);
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
