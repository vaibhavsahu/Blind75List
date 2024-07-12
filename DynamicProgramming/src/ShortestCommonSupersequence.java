public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int [][] result = new int [l1+1][l2+1];

        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    result[i][j] =  Math.max(result[i-1][j-1], Math.max(result[i-1][j], result[i][j-1]));
                } else {
                    result[i][j] =  Math.max(1+result[i-1][j-1], Math.max(result[i-1][j], result[i][j-1]));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while(l1 != 0 && l2 != 0){
            if(result[l1][l2] == result[l1-1][l2]){
                sb.append(word1.charAt(l1-1));
                l1--;
            } else if(result[l1][l2] == result[l1][l2-1]){
                sb.append(word2.charAt(l2-1));
                l2--;
            } else{
                sb.append(word1.charAt(l1-1));
                l2--;
                l1--;
            }
        }

        while(l1-1 >= 0){
            sb.append(word1.charAt(l1-1));
            l1--;
        }
        while(l2-1 >= 0){
            sb.append(word2.charAt(l2-1));
            l2--;
        }

        sb.reverse();
        return sb.toString();
    }
}
