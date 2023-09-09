//https://leetcode.com/problems/left-and-right-sum-differences/
public class LeftRightSumDifference {
    public int[] leftRightDifference(int[] nums) {

        int [] ans = new int[nums.length];
        int [] leftSum = new int[nums.length];

        int [] rightSum = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1]+nums[i-1];
        }

        for(int i = nums.length-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1]+nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;

    }
}
