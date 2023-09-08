import java.util.Arrays;
//https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0 || k == 0)
                break;
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }

        }

        int sum = Arrays.stream(nums).boxed().reduce(0, Integer::sum);

        return  sum - (k % 2) * Arrays.stream(nums).min().getAsInt() * 2;

    }
}
