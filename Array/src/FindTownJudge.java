public class FindTownJudge {
    //https://leetcode.com/problems/find-the-town-judge/
    public int findJudge(int n, int[][] trusts) {
        if (trusts.length < n - 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        for (int[] relation : trusts) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
