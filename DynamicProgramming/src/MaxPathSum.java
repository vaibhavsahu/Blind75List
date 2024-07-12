import java.util.ArrayList;

public class MaxPathSum {


    static int maxPathSum(ArrayList<ArrayList<Integer>> grid){
        int rows = grid.size();
        int cols = grid.get(0).size();
        int dp[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid.get(i).get(j);
                }
                else if (j == 0) {
                    // First column.
                    dp[i][j] = dp[i - 1][j] + grid.get(i).get(j);
                }
                else if (i == 0) {
                    // First row.
                    dp[i][j] = dp[i][j - 1] + grid.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid.get(i).get(j);
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
