import java.util.ArrayList;
import java.util.List;

class CountSubIslands {
    public static int countSubIslands(int[][] grid1, int[][] grid2) {

        int rowLength = grid2.length;
        int colLength = grid2[0].length;
        // handle non-overlapped islands
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid1[row][col] == 0 && grid2[row][col] == 1) {
                    dfs(grid2, row, col);
                }
            }
        }

        // calculate the overlapped islands
        int res = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid2[row][col] == 1) {
                    res++;
                    dfs(grid2, row, col);
                }
            }
        }

        return res;
    }


    private static void dfs(int[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (row < 0 || col < 0 || row >= rowLength || col >= colLength) {
            return;
        }

        if (grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        int [][] grid1 = {{1,1,1,0,0}
                            ,{0,1,1,1,1},
                            {0,0,0,0,0}
                            ,{1,0,0,0,0}
                            ,{1,1,0,1,1}};
        int [][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(countSubIslands(grid1, grid2));
    }
}
