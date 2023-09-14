import java.util.Comparator;
import java.util.List;

public class ValidWordSquare {
//https://leetcode.com/problems/valid-word-square
    public static boolean validWordSquare(List<String> words) {
        int maxLen = words.stream().max(Comparator.comparingInt(String::length)).get().length();
        char [][] matrix = new char[words.size()][maxLen];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j > words.get(i).length()-1){
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = words.get(i).charAt(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            char [] row =  matrix[i];
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while(i < matrix.length && j < matrix.length && matrix[j][i] != ' '){
                sb.append(matrix[j][i]);
                j++;
            }
            if(!String.valueOf(row).trim().contentEquals(sb)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validWordSquare(List.of("abc","b")));
    }
}
