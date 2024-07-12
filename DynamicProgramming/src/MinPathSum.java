public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 1; i < M; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < N; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                grid[i][j] = Math.min(grid[i][j - 1] + grid[i][j],
                        grid[i - 1][j] + grid[i][j]);

            }
        }
        return grid[M - 1][N - 1];
    }
}
