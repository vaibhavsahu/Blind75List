public class NumClosedIslands {
    public static int closedIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0 && dfs(grid, i, j, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            return false;
        }

        if (grid[i][j] == 1 || vis[i][j]) {
            return true;
        }

        // mark visited
        vis[i][j] = true;
        return dfs(grid, i + 1, j, vis) || dfs(grid, i, j + 1, vis) || dfs(grid, i, j - 1, vis) ||dfs(grid, i - 1, j, vis);

//        // call 4 directions
//        if(!dfs(grid, i, j + 1, vis)){
//            isClosed = false;
//        }
//        if(!dfs(grid, i, j - 1, vis)){
//            isClosed = false;
//        }
//        if(!dfs(grid, i - 1, j, vis)){
//            isClosed = false;
//        }
       // return isClosed;
    }
}