public class InterLeavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l1+l2 != l3) return false;
        boolean [][] result = new boolean[l1+1][l2+1];
        result[0][0] = true;
        for(int i = 1; i <= l1; i++){
            result[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && result[i-1][0];
        }
        for(int i = 1; i <= l2; i++){
            result[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && result[0][i-1];
        }

        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                result[i][j] = (result[i-1][j]
                        && s1.charAt(i-1) == s3.charAt(i+j-1))
                        || (result[i][j-1] &&
                        s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return result[l1][l2];
    }
}
