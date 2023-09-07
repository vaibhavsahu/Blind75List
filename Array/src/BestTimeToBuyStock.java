/*2. Best Time to Buy and Sell Stock
        You are given an array of prices where prices[i] is the price of a given stock on an ith day.
        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

    */


public class BestTimeToBuyStock {
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
    // two pointer technique, left and right
    public static int maxProfit(int [] prices){
        var left = 0;
        var right = 1;

        var max = 0;

        while(right < prices.length){
            if(prices[left] < prices[right]){
                max = Math.max(max, prices[right]- prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
