import java.util.ArrayList;

public class MinCostClimbStairs {
    static int minCost(ArrayList<Integer> cost){

        if(cost.size() == 1) return cost.get(0);

        int [] dp = new int[cost.size()+1];


        dp[0] = 0; // base case
        dp[1] = 0; // base case

        for(int i = 2; i <= cost.size(); i++) {
            // Here there are 2 ways to reach i-th step either from '(i - 1)'-th step or from '(i - 2)'-th step.
            dp[i] = Math.min(dp[i - 1] + cost.get(i - 1), dp[i - 2] + cost.get(i - 2));
        }

        return dp[cost.size()];
    }

    static int minCostSpaceOptimized(ArrayList<Integer> cost){

        for(int i = cost.size()-3;i>=0;i--){
            cost.set(i,  Math.min(cost.get(i+1),cost.get(i+2)));
        }
        return Math.min(cost.get(0),cost.get(1));
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];

        for(int i = 2; i < cost.length; i++) {
            cost[i] =  Math.min(cost[i-1], cost[i-2])+cost[i];
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }

}
