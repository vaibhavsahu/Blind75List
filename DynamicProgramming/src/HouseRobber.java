import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[1] = Math.max(nums[0], nums[1]); //special base case

        for(int i = 2; i < nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        }

        return nums[nums.length-1];
    }

    public int rob2(int [] nums) {
        if (nums.length == 1) return nums[0];

        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }


        if (nums.length == 4) {
            return Math.max(nums[0]+nums[2], nums[1]+nums[3]);
        }

        result1[2] = nums[2];
        result1[3] = Math.max(nums[2], nums[3]);

        for (int i = 4; i < nums.length - 1; i++) {
            result1[i] = Math.max(result1[i - 1], result1[i - 2] + nums[i]);
        }

        int res1 = nums[0]+result1[result1.length-2];

        result2[1] = nums[1];
        result2[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            result2[i] = Math.max(result2[i - 1], result2[i - 2] + nums[i]);
        }

        return Math.max(res1, result2[nums.length-1]);
    }
}
