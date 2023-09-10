//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int [] account: accounts){
            int currBalance = 0;
            for(int balance: account){
                currBalance += balance;
            }
            max = Math.max(max, currBalance);
        }
        return max;
    }
}
