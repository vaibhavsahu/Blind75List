/*
Given an integer array nums, find the subarray with the largest sum,
        and return its sum.
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
        Input: nums = [1]
        Output: 1
        Explanation: The subarray [1] has the largest sum of 1.

 */

public class MaximumSubarray {
    //use two pointers technique
    //leftIndex, rightIndex
    //start at leftIndex = 0, rightIndex = 1
    //keep track of maxSum, and maxSumSoFar
    //if adding number at rightIndex reduces the sum, then shift the rightIndex, and leftIndex
    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //Output: 6
    //using sliding window technique
    public static int maxSubArray1(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            currSum += nums[right];
            if(currSum < 0) currSum = 0; //reset the currSum to zero if it reaches -ve
            while(currSum >= maxSum){
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return maxSum;
    }

    //alternative implementation
    public static int maxSubArray2(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
                for (int num : nums) {
            if (currSum < 0)
                currSum = 0;

            currSum += num;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{ -2,1,-3,4,-1,2,1,-5,4}));
    }
}
