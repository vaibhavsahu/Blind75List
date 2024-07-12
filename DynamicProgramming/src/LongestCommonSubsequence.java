import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[][] result = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i-1) != text2.charAt(j-1)) {
                    result[i][j] = Math.max(result[i-1][j-1], Math.max(result[i-1][j], result[i][j-1]));
                } else {
                    result[i][j] = Math.max(1+result[i-1][j-1], Math.max(result[i-1][j], result[i][j-1]));
                }
            }
        }
        Set<String> list = new HashSet<>();
        getAllLCS(text1, text2, l1, l2, result, list, "");
        System.out.println(list);
        return result[l1][l2];
    }

    public static void getAllLCS(String s1, String s2, int l1, int l2,
                          int[][] result, Set<String> list, String sb){

        if(l1 == 0 || l2 == 0){
            list.add(sb);
            return;
        }

        if(s1.charAt(l1-1) == s2.charAt(l2-1)){
            sb = s1.charAt(l1-1)+sb;
            getAllLCS(s1, s2, l1-1, l2-1, result, list, sb);
        } else if (result[l1-1][l2] == result[l1][l2-1]) {
            getAllLCS(s1, s2, l1-1, l2, result, list, sb);
            getAllLCS(s1, s2, l1, l2-1, result, list, sb);
        } else if(result[l1-1][l2] > result[l1][l2-1]){
            getAllLCS(s1, s2, l1-1, l2, result, list, sb);
        } else{
            getAllLCS(s1, s2, l1, l2-1, result, list, sb);
        }
    }
}
