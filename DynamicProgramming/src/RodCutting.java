public class RodCutting {

    public static int maxProfit(int n, int[] price){
        int [] result = new int[n+1];

        result[1] = price[0];

        for (int i = 2; i <= n; i++) {
            int bestPrice = price[i-1];
            for (int j = 1; j < i; j++) {
                 bestPrice = Math.max(bestPrice, price[j-1]+result[i-j]);
            }
            result[i] = bestPrice;
        }
        return result[n];
    }
}
