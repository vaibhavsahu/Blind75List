public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            result[i][i] = 1;
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    result[i][j] = result[i+1][j-1]+2;
                } else {
                    result[i][j] = Math.max(result[i+1][j],result[i][j-1]);
                }
            }
        }
        return result[0][n-1];
    }
}
