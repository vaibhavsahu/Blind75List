import java.util.Arrays;

public class Sudoku {

    private static Sudoku instance = null; // lazy loading

    private boolean finished = false;

    private char[][] board = new char[9][9];

    private Sudoku() {
    }

    public static Sudoku getInstance() {
        if (instance == null) {
            instance = new Sudoku();
        }
        return instance;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void solve() {
        backtrack(board, 0, 0);
    }


    public void backtrack(char[][] board, int row, int col) {
        if (row == 8 && col == 8 && board[row][col] != '0') {
            finished = true;
            return;
        }

        if (row == 9) { // nextRow == 9 means we have already processed cell [8, 8] which marks the end of Sudoku game
            finished = true;
            return;
        }
        if (board[row][col] == '0') { // if current cell contains '0', solve for the current cell
            boolean[] suitableCandidatesForCurrentCell = constructCandidates(board, row, col);
            for (int k = 1; k <= 9; k++) {
                if (suitableCandidatesForCurrentCell[k - 1]) {
                    board[row][col] = (char) (k + '0'); //makeMove
                    int nextRow = col == 8 ? row + 1 : row; // row of current cell
                    // we go to next row only when col has reached 8, otherwise row remains same
                    int nextCol = col == 8 ? 0 : col + 1; // column of current cell
                    // new col resets to 0 if previous col has reached 8, otherwise to get new col we just shift one cell towards right
                    // which is same as incrementing the previous col by 1
                    backtrack(board, nextRow, nextCol); // recursively call backtrack(...)

                    if (finished) { // early termination
                        return;
                    }
                    board[row][col] = '0'; // undoMove
                }
            }
        } else {
            int nextRow = col == 8 ? row + 1 : row; // row of current cell
            // we go to next row only when col has reached 8, otherwise row remains same
            int nextCol = col == 8 ? 0 : col + 1; // column of current cell
            // new col resets to 0 if previous col has reached 8, otherwise to get new col we just shift one cell towards right
            backtrack(board, nextRow, nextCol);
        }
    }

    private boolean[] constructCandidates(char[][] board, int row, int col) {
        boolean[] candidates = new boolean[9];
        Arrays.fill(candidates, true);
        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '0') {
                candidates[board[i][col] - '0' - 1] = false;
            }
        }
        // row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '0') {
                candidates[board[row][j] - '0' - 1] = false;
            }
        }
        // sub-box check
        int topLeftRow = (row / 3) * 3;
        int topLeftCol = (col / 3) * 3;
        // once we have computed the row and col of the top left point of the sub-box
        // we know that the sub-box would be a square matrix
        // with right bottom point =  [topLeftRow + 3, topLeftCol + 3]
        for (int i = topLeftRow; i < topLeftRow + 3; i++) {
            for (int j = topLeftCol; j < topLeftCol + 3; j++) {
                if (board[i][j] != '0') {
                    candidates[board[i][j] - 1 - '0'] = false;
                }
            }
        }
        return candidates;
    }

    private void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Sudoku sudoku = Sudoku.getInstance();
        char[][] board =
                        {{'3', '0', '6', '5', '0', '8', '4', '0', '0'},
                        {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '8', '7', '0', '0', '0', '0', '3', '1'},
                        {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
                        {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
                        {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
                        {'1', '3', '0', '0', '0', '0', '2', '5', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
                        {'0', '0', '5', '2', '0', '6', '3', '0', '0'}};
        sudoku.setBoard(board);
        sudoku.solve();
        sudoku.printBoard();
    }
}

/*
Output:
3  1  6  5  7  8  4  9  2
5  2  9  1  3  4  7  6  8
4  8  7  6  2  9  5  3  1
2  6  3  4  1  5  9  8  7
9  7  4  8  6  3  1  2  5
8  5  1  7  9  2  6  4  3
1  3  8  9  4  7  2  5  6
6  9  2  3  5  1  8  7  4
7  4  5  2  8  6  3  1  9
*/