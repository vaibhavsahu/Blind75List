import java.util.Arrays;

public class BurstBalloons {
    public static int maxBurstBalloons(int [] matrix){
        int [] newArray = new int[matrix.length+2];
        newArray[0] = 1;
        newArray[newArray.length-1] = 1;
        int N = newArray.length;

        for(int i = 0; i < matrix.length; i++){
            newArray[i+1] = matrix[i];
        }

        int [][] result = new int[N][N];

        for (int row = N-2; row >= 0 ; row--) {
            for (int col = row+2; col < N ; col++) {
                for(int k = row+1; k < col; k++){
                    result[row][col] = Math.max(result[row][col],
                                    result[row][k]+result[k][col]+
                                    (newArray[row]*newArray[col]*newArray[k]));
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result[0][N-1];
    }
}
