public class SubarrayOddSum {
    public int numOfSubarrays(int[] nums) {
        int count = 0, sum = 0;

        var map = new int[2];
        map[0] = 1;

        var mod = 1_000_000_007;

        for (var num : nums) {
            sum += num;

            if (sum % 2 == 0) {
                count = (count + map[1]) % mod;
                map[0]++;
            } else {
                count = (count + map[0]) % mod;
                map[1]++;
            }
        }

        return count;
    }
}
