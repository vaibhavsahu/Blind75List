public class LongerContiguousSegmentsOfOnesThanZeros {
    //https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
    public boolean checkZeroOnes(String s) {
        int onesCount = findMaxConsecutive(s, '1');
        int zerosCount = findMaxConsecutive(s, '0');

        return onesCount > zerosCount;
    }

    public int findMaxConsecutive(String s, char ch) {
        int count = 0;
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) {
                count += 1;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
