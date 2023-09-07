import java.util.ArrayList;
import java.util.List;

class CountSubIslands {
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
//        boolean[][] visited1 = new boolean[grid1.length][grid1[0].length];
//        boolean[][] visited2 = new boolean[grid2.length][grid2[0].length];
//
//        List<List<Pair<Integer, Integer>>> islands1 = new ArrayList<>();
//        List<List<Pair<Integer, Integer>>> islands2 = new ArrayList<>();
//
//        for (int i = 0; i < grid1.length; i++) {
//            for (int j = 0; j < grid1[0].length; j++) {
//                List<Pair<Integer, Integer>> list = new ArrayList<>();
//                if (!visited1[i][j] && grid1[i][j] == 1) {
//                    dfs(grid1, i, j, visited1, list);
//                }
//                if (!list.isEmpty())
//                    islands1.add(list);
//            }
//        }
//
//
//        for (int i = 0; i < grid2.length; i++) {
//            for (int j = 0; j < grid2[0].length; j++) {
//                List<Pair<Integer, Integer>> list = new ArrayList<>();
//                if (!visited2[i][j] && grid2[i][j] == 1) {
//                    dfs(grid2, i, j, visited2, list);
//                }
//                if (!list.isEmpty())
//                    islands2.add(list);
//            }
//        }
        int rowLength = grid2.length;
        int colLength = grid2[0].length;
        // handle non-overlapped islands
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid1[row][col] == 0 && grid2[row][col] == 1) {
                    dfs(grid2, row, col);
                }
            }
        }

        // calculate the overlapped islands
        int res = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid2[row][col] == 1) {
                    res++;
                    dfs(grid2, row, col);
                }
            }
        }

        return res;

        // return
       // return 0;
    }

//    public static int compareSubIslands(List<List<Pair<Integer, Integer>>> islands1,
//                                        List<List<Pair<Integer, Integer>>> islands2){
//
//        for(int i = 0; i < islands2.size(); i++){
//            List<Pair<Integer, Integer>> subIsland2 = islands2.get(i);
//            List<Pair<Integer, Integer>> subIsland1 = islands1.get(i);
//
//
//        }
//
//    }


//    public static void dfs(int[][] grid, int i, int j,
//                           boolean[][] visited,
//                           List<Pair<Integer, Integer>> list) {
//        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]!=1)
//            return;
//
//
//        visited[i][j] = true;
//        list.add(new Pair<>(i, j));
//
//
//        dfs(grid, i - 1, j, visited, list);
//        dfs(grid, i, j + 1, visited, list);
//        dfs(grid, i + 1, j, visited, list);
//        dfs(grid, i, j - 1, visited, list);
//
//    }

    private static void dfs(int[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (row < 0 || col < 0 || row >= rowLength || col >= colLength) {
            return;
        }

        if (grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        int [][] grid1 = {{1,1,1,0,0}
                            ,{0,1,1,1,1},
                            {0,0,0,0,0}
                            ,{1,0,0,0,0}
                            ,{1,1,0,1,1}};
        int [][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(countSubIslands(grid1, grid2));
    }
}
