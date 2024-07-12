public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int [] result = new int[amount+1];

        result[0] = 1;

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i-1] >= 0){
                    result[j] += result[j - coins[i-1]];
                }
            }
        }
        return result[amount];
    }
}
