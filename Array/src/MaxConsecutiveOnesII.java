public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        //https://leetcode.com/problems/max-consecutive-ones-ii/
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        int count = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            while(count > 1){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
