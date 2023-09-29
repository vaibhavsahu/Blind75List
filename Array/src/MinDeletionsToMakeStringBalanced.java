public class MinDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
//https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
        int countB = 0;
        int removals = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (countB > 0) {
                    ++removals;
                    --countB;
                }
            } else {
                ++countB;
            }
        }
        return removals;
    }
}
