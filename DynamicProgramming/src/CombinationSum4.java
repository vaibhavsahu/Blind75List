public class CombinationSum4 {
    public int combinationSum4(int[] coins, int amount) {
        int [] result = new int[amount+1];

        result[0] = 1;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    result[i] += result[i-coin];
                }
            }
        }
        return result[amount];
    }
}
