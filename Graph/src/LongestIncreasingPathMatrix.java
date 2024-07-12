

public class LongestIncreasingPathMatrix {
    int[][] neighbor = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) return 0;
        int[][] dis = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, dis));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] dis) {
        if (dis[x][y] != 0) return dis[x][y];

        for (int i = 0; i < 4; i++) {
            int k = x + neighbor[i][0];
            int l = y + neighbor[i][1];
            if (k >= 0 && k < matrix.length && l >= 0 && l < matrix[0].length && matrix[x][y] < matrix[k][l]) {
                dis[x][y] = Math.max(dis[x][y], dfs(matrix, k, l, dis));
            }
        }

        return ++dis[x][y];
    }
}
