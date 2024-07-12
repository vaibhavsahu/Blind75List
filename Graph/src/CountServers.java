public class CountServers {
    public int countServers(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int countFishes = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0){
                    countFishes += dfs(grid, i, j, visited);
                }
            }

        }
        return countFishes;
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
}
