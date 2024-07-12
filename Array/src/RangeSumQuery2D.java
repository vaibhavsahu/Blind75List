public class RangeSumQuery2D {
    int [][] prefixSum;
    public RangeSumQuery2D(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];
        prefixSum[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            prefixSum[i][0] = (matrix[i][0]+prefixSum[i-1][0]);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            prefixSum[0][i] = (matrix[0][i]+prefixSum[0][i-1]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                prefixSum[i][j] = (matrix[i][j]+prefixSum[i][j-1] + prefixSum[i-1][j]-prefixSum[i-1][j-1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
            return prefixSum[row2][col2];
        } else if (row1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row2][col1-1];
        } else if (col1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row1-1][col2];
        }
        return prefixSum[row2][col2] - prefixSum[row2][col1-1] - prefixSum[row1-1][col2]+prefixSum[row1-1][col1-1];
    }
}
