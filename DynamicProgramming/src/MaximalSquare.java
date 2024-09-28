public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int globalMax = 0;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if((i == 0 || j == 0) && matrix[i][j] == '1'){
                    result[i][j] = 1;
                } else if (matrix[i][j] == '1') {
                    result[i][j] = 1 + Math.min(Math.min(result[i - 1][j - 1], result[i][j - 1]),
                            result[i - 1][j]);
                }
                globalMax = Math.max(result[i][j], globalMax);
            }
        }
        return globalMax * globalMax;
    }
}