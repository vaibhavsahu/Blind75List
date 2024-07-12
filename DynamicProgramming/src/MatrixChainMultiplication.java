public class MatrixChainMultiplication {
    public int chainMatrixProduct(int [] matrix){
        int n = matrix.length;
        int [][] result = new int[n][n];

        for (int row = n-2; row >= 0 ; row--) {
            for (int col = row+2; col < n ; col++) {
                for(int k = row+1; k < col; k++){
                    result[row][col] = Math.min(result[row][col],
                            result[row][k]+result[k][col]+(matrix[row]*matrix[col]*matrix[k]));
                }
            }
        }
        return result[0][n-1];
    }
}
