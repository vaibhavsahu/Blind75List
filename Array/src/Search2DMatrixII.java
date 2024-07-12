public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxCol = n-1;
        int maxRow = 0;
        while (maxCol >= 0 && maxRow <= m-1){
            if(target == matrix[maxRow][maxCol]) return true;
            else if(target < matrix[maxRow][maxCol]) maxCol--;
            else maxRow++;
        }
        return false;
    }
}
