import java.util.Arrays;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        int [][] result = new int[costs.length][costs[0].length];

        for(int i = 0; i < costs[0].length; i++){
            result[0][i] = costs[0][i];
        }

        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                int best = Integer.MAX_VALUE;
                for(int k = 0; k < costs[0].length; k++){ //optimize this to constant time
                    if(j != k){
                        best = Math.min(best, result[i-1][k]);
                    }
                }
                result[i][j]  = best+costs[i][j];
            }
        }

        return Arrays.stream(result[costs.length-1]).min().getAsInt();
    }
}
