import java.util.Arrays;
//https://leetcode.com/problems/maximum-average-subarray-i
public class MaxAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        if(nums.length == 1){
            return (double)(nums[0])/(double)(k);
        }

        if(nums.length == k){
            double sum = Arrays.stream(nums).sum();
            return sum/(double)(k);
        }

        int left = 0; int right = 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while(right < nums.length){
            sum += nums[right];
            if(right-left+1 == k){
                maxSum = Math.max(sum, maxSum);
                System.out.println(maxSum);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return (double)(maxSum)/(double)(k);
    }
}
