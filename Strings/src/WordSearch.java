import java.util.List;

public class WordSearch {
    boolean [] globalAns = {false};
    static int [] idx = {-1, 0,0, 1};
    static int [] idy = {0, -1, 1, 0};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++){
                dfs(word, 0, row, col, board, m, n);
                if(globalAns[0]) break;
            }
        }
        return globalAns[0];
    }


    public void dfs(String word, int i, int x, int y, char[][] board, int m , int n){
        if(word.charAt(i) != board[x][y]) return;

        if(i == word.length()-1) {
            globalAns[0] = true;
            return;
        }

        char temp = board[x][y];
        board[x][y] = '.';

        for(int index = 0; index < idx.length; index++){
            int nx = x+idx[index];
            int ny = y+idy[index];
            if(nx >= 0 && ny >= 0
                    && nx < m
                    && ny < n && board[nx][ny] != '.'){
                dfs(word, i+1, nx, ny ,board, m, n);
            }
        }

        board[x][y] = temp;
    }
}
