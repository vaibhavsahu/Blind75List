import java.util.ArrayList;
import java.util.List;

public class MaxFishInGrid {
    public static int findMaxFish(int[][] grid) {
        int maxFish = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int countFishes = 0;

                if(grid[i][j] > 0){
                    countFishes += dfs(grid, i, j, visited);
                }
                maxFish = Math.max(countFishes, maxFish);
            }

        }
        return maxFish;
    }

    public static int dfs(int [][] grid, int i, int j, boolean [][] vis){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || vis[i][j] || grid[i][j] == 0){
            return 0;
        }

        // mark visited
        vis[i][j] = true;

        // call 4 directions
        int total = grid[i][j];
        total += dfs(grid, i+1, j, vis);
        total += dfs(grid, i, j+1, vis);
        total += dfs(grid, i, j-1, vis);
        total += dfs(grid, i-1, j, vis);
        return total;
    }


    public static void main(String[] args) {
        int [][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(findMaxFish(grid));

    }
}
