import java.util.Arrays;
import java.util.List;

public class MaxSafenessFactor {
    public static int maximumSafenessFactor(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();
        if(grid.get(0).get(0) == 1 || grid.get(m-1).get(n-1) == 1){
            return 0;
        }

        boolean [][] visited = new boolean[m][n];
        int row = 0;
        int col = 0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1){
                    row = i;
                    col = j;
                    grid.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        //update safe distance
        int maxSafFactor = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 0){
                    maxSafFactor = Math.abs(row-i)+ Math.abs(j-col);
                    grid.get(i).set(j, maxSafFactor);
                }
            }
        }
        return maxSafFactor;
    }

   // public int
   public static void main(String[] args) {

        List<List<Integer>> grid = Arrays.asList(Arrays.asList(0,0,1),
                Arrays.asList(0,0,0),
                Arrays.asList(0,0,0));
       System.out.println(maximumSafenessFactor(grid));
   }
}
