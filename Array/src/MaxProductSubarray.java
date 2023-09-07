/*
Given an integer array nums, find a subarray
        that has the largest product, and return the product.
        Input: nums = [2,3,-2,4]
        Output: 6
        Explanation: [2,3] has the largest product 6.
        Input: nums = [-2,0,-1]
        Output: 0
        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubarray {

    public  static int maxProduct(int [] nums){
        int currMax = 1;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {
            currMax *= num;
            result = Math.max(result, currMax);
            if (currMax == 0) currMax = 1;
        }

        currMax = 1;
        for(int i = nums.length-1; i >= 0; i--){
            currMax*=nums[i];
            result = Math.max(result, currMax);
            if(currMax == 0) currMax = 1;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
