import java.util.ArrayList;

public class CountIslandsIK {
    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        boolean [][] visited = new boolean[rows][cols];

        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && matrix.get(i).get(j) == 1) {
                    count++;
                    dfs(matrix, visited, rows, cols, i, j);
                }
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> matrix, boolean [][] visited, int rows,
                    int cols, int row, int col){
        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || matrix.get(row).get(col) == 0) return;

        visited[row][col] = true;

        dfs(matrix, visited, rows, cols, row+1, col);
        dfs(matrix, visited, rows, cols, row-1, col);
        dfs(matrix, visited, rows, cols, row, col+1);
        dfs(matrix, visited, rows, cols, row, col-1);
        dfs(matrix, visited, rows, cols, row+1, col+1);
        dfs(matrix, visited, rows, cols, row-1, col-1);
        dfs(matrix, visited, rows, cols, row+1, col-1);
        dfs(matrix, visited, rows, cols, row-1, col+1);

    }

}
