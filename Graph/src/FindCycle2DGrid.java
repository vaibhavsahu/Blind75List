public class FindCycle2DGrid {

    public boolean containsCycle(char[][] grid) {
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int [][] count = new int [grid.length][grid[0].length];
        boolean isCyclic = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
             //   isCyclic = dfs(grid, i, j, visited);
                if(isCyclic) return true;
            }
        }
        return isCyclic;
    }

//    public boolean dfs(char[][] grid, int i, int j, boolean [][] visited){
//        if( i < 0 || j < 0 || i == grid.length || j == grid[0].length){
//            return false;
//        }
//
//
//
//    }
}
