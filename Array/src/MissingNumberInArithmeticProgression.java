public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
//https://leetcode.com/problems/missing-number-in-arithmetic-progression/
//1228. Missing Number In Arithmetic Progression

        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == arr[0] + mid * diff) start = mid + 1;
            else end = mid - 1;
        }
        return arr[0] + start * diff;
    }
}
