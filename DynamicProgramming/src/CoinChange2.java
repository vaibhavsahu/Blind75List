public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int [] result = new int[amount+1];

        result[0] = 1;

        for(var coin: coins){
            for(int j = 1; j <= amount; j++){
                if(j - coin >= 0){
                    result[j] += result[j - coin];
                }
            }
        }
        return result[amount];
    }
}
