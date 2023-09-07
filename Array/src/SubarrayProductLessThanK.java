/*
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;

       int count = 0;
       int currProd = 1;


        while(right < nums.length){
            currProd *= nums[right];

            while( currProd >= k && left <= right){
                currProd /= nums[left];
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;

    }
}
