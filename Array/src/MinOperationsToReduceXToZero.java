import java.util.Arrays;

public class MinOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int answer = Integer.MIN_VALUE;
        int k = Arrays.stream(nums).sum()-x;

        int left = 0;
        int right = 0;
        int currSum = 0;
        while(right < nums.length){
            currSum += nums[right];
            while(left <= right && currSum > k){
                currSum -= nums[left];
                left++;
            }
            if(currSum == k){
                answer = Math.max(answer, right-left+1);
            }
            right++;
        }
        return answer == Integer.MIN_VALUE ? -1 : nums.length-answer;
    }
}
