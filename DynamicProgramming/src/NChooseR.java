public class NChooseR {
    static int nChooseR(int n , int r){
        if(r > n) return 0;

        int [][] result = new int[n+1][r+1];

        for (int i = 0; i <= n ; i++) {
            result[i][0]  = 1;
        }

        for (int j = 0; j <= r ;j++) {
            result[j][j]  = 1;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= r; j++) {
                result[i][j] = result[i-1][j]+result[i-1][j-1];
            }
        }
        return result[n][r];
    }
}
