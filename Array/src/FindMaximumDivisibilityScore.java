public class FindMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        //https://leetcode.com/problems/find-the-maximum-divisibility-score/
        int maxScore=-1;
        int maxElement=-1;
        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0)
                    score++;
            }
            if (score == maxScore)
                maxElement = Math.min(maxElement, divisor);
            else if (score > maxScore) {
                maxScore = score;
                maxElement = divisor;
            }
        }
        return maxElement;
    }
}
