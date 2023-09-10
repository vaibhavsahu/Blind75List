public class MinValueToGetPositiveStepByStepSum {
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    public int minStartValue(int[] nums) {
        int minVal = 0;
        int total = 0;

        for (int num : nums) {
            total += num;
            minVal = Math.min(minVal, total);
        }

        return -minVal + 1;
    }
}
