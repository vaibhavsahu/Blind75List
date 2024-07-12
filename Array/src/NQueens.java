import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

    static ArrayList<ArrayList<String>> find_all_arrangements(Integer n) {
        String [][] board = new String[n][n];
        for(String [] arr: board)
            Arrays.fill(arr, "-");
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
                find_all_arrangements_helper(board, 0, 0);
//                //check if board
//            }
//        }

        return new ArrayList<>();
    }

    private static void find_all_arrangements_helper(String[][] board, int row, int col) {

        if(validPosition(board, row, col)){
            board[row][col] = "Q";
            find_all_arrangements_helper(board, row+1, col);
            board[row][col] = "-";
            find_all_arrangements_helper(board, row, col+1);
        }
    }

    private static boolean validPosition(String[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        //check the current row
        for (int j = 0; j < board[0].length; j++) {
            if(board[row][j].equals("Q")) return false;
        }
        //check the current col
        for (int i = 0; i < board.length; i++) {
            if(board[i][col].equals("Q")) return false;
        }

        //check diagonal
        for (int i = 0, j= 0; i < board.length && j < board[0].length; i++, j++) {
            if(board[i][j].equals("Q")) return false;
        }
        return true;
    }

}
