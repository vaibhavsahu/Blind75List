public class LongestAlternatingSubarray {

    public static int alternatingSubarray(int[] nums) {
        int left = 0, right = 1, max = 1;
        while(right < nums.length-1) {
            if (Math.abs(nums[right] - nums[right - 1]) > 1 || nums[right] - nums[right-1] == 0) {
               right++;
               continue;
            }
            left = right;
            if (nums[right] - nums[right - 1] == (-1 * (nums[right] - nums[right + 1]))) {
                right++;
                continue;
            }
            while (right < nums.length - 1
                    && nums[right] - nums[right - 1] == nums[right] - nums[right + 1]) {
                right++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return left == 0 && right == nums.length-1 ? -1 : max+1;
    }

    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int []{14,30,29,49,3,23,44,21,26,52}));
    }
}
