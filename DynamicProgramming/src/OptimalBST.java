import java.lang.reflect.Array;
import java.util.Arrays;

public class OptimalBST {
    public static int optimalCost(int [] roots, int [] keys){
        int [][] dp = new int[roots.length+1][keys.length+1];

        for(var arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0; i <= roots.length; i++){
            dp[i][i] = 0;
        }

        for(int i=0; i<roots.length; i++){
            dp[i][i+1] = keys[i];
        }

        for(int i= roots.length-2; i >= 0; i--){
            for(int j=i+2; j <= roots.length; j++){
                int freqSum  =0;
                for(var m = i; m < j; m++){
                    freqSum += keys[m];
                }
                for(int k=i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + freqSum);
                }
            }
        }


        return dp[0][roots.length];
    }

    public static void main(String[] args) {
        System.out.println(optimalCost(new int[]{10, 20}, new int[]{34, 50}));
    }
}
