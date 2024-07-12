import java.util.Arrays;
//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        int prefixSum = 0;
        int average = sum / 3;
        int cnt = 0;
        for (int a : arr) {
            prefixSum += a;
            if (prefixSum == average) { // find the average: sum / 3
                ++cnt; // find an average, increase the counter.
                prefixSum = 0; // reset part.
            }
        }
        return cnt >= 3 && sum % 3 == 0;
    }
}
