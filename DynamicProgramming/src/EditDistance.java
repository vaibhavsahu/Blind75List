public class EditDistance {
    public int minDistance(String word1, String word2) {


        int l1 = word1.length();
        int l2 = word2.length();

        int[][] result = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            result[i][0] = i;
        }

        for (int i = 1; i <= l2; i++) {
            result[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    result[i][j] = 1 + Math.min(Math.min(result[i - 1][j],
                            result[i][j - 1]), result[i - 1][j - 1]);
                } else {
                    result[i][j] = result[i - 1][j - 1];
                }
            }
        }
        return result[l1][l2];
    }
}
