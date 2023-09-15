public class PatternOfLengthMRepeatedKOrMoreTimes {
        //https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }
}
