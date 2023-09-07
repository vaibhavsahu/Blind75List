import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Pair<U, V>{
     U first;
     V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst(){
        return this.first;
    }
}

public class SorroundedRegions {

   // public void solve(char[][] board) {
   public static void main(String[] args) {
       String [][] board = {{"X","O","X","O","X","O"},
                            {"O","X","O","X","O","X"},
                            {"X","O","X","O","X","O"},
                            {"O","X","O","X","O","X"}};


        List<Pair<Integer, Integer>> borderCells = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    borderCells.add(new Pair<>(i, j));
                }
            }
        }

        for(Pair<Integer, Integer> pair : borderCells){
            dfs(board, pair.first, pair.second);
        }
       System.out.println(Arrays.deepToString(board));

        //flip all entries which are O to X
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               if(Objects.equals(board[i][j],  "O")){
                   board[i][j] = "X";
               }
           }
       }


       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               if(Objects.equals(board[i][j],  "E")){
                   board[i][j] = "O";
               }
           }
       }

       //revert all cells marked with E to O


    }

    public static void dfs(String[][] board, int row, int col){
        if (!Objects.equals(board[row][col], "O")) {
            return;
        }

        board[row][col] = "E";

        if(row > 0){
            dfs(board, row-1, col);
        }
        if(col < board[0].length-1){
            dfs(board, row, col+1);
        }
        if(row < board.length-1){
            dfs(board, row+1, col);
        }
        if(col > 0){
            dfs(board, row, col-1);
        }
    }
}
