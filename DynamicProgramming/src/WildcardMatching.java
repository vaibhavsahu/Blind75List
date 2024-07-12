public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] result = new boolean[m + 1][n + 1];

        result[0][0] = true;

        for (int col = 1; col <= n; col++) {
            if (p.charAt(col - 1) != '*')
                break;
            result[0][col] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i - 1][j] || result[i][j - 1];
                }
            }
        }
        return result[m][n];
    }
}
