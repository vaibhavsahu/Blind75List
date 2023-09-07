public class NumSubarraysLCLEqualsK {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int right = 0;
        int left = 0;

        while(right < nums.length){
            int runningLcm = nums[right];
            left = right;
           while(left < nums.length){
                runningLcm = lcm(runningLcm, nums[left]);
                if (runningLcm > k)
                    break;
                if (runningLcm == k)
                    ++ans;
                left++;
            }
           right++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
