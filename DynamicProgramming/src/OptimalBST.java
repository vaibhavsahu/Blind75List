public class OptimalBST {
    public int optimalCost(int [] roots, int [] keys){
        int [][] dp = new int[roots.length][keys.length];

        for(int i=0; i<roots.length; i++){
            dp[i][i] = keys[i];
        }

        for(int i= roots.length-2; i >= 0; i--){
            for(int j=i+2; j < roots.length; j++){
                for(int k=i+1; k < j; k++){
                    dp[i][j] += Math.min(dp[i][j], dp[i][k] + dp[k][j] + keys[i]+keys[j]+keys[k]);
                }
            }
        }
        return dp[0][roots.length-1];
    }
}
