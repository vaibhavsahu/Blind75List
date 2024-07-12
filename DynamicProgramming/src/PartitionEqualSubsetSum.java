import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0) return false;

        int k = sum/2;

        boolean [][]result = new boolean[nums.length+1][k+1];

        result[0][0] = true;

        for(int i = 1; i <= nums.length; i++){
            result[i][0] = true;
        }

        for(int i = 1; i <= k; i++){
            result[0][i] = false;
        }

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= k; j++){
                result[i][j] = result[i-1][j];
                if(j >= nums[i-1]){
                    result[i][j] = result[i][j] || result[i-1][j-nums[i-1]];
                }
            }
        }
        return result[nums.length][k];
    }
}
