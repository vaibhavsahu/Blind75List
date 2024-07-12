public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 1;

        for(int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if( j == 0){
                    obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
                } else if ( i == 0){
                    obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
                } else {
                    if (obstacleGrid[i][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    } else {
                        obstacleGrid[i][j] = 0;
                    }
                }
            }
        }

        return obstacleGrid[M-1][N - 1];
    }
}
