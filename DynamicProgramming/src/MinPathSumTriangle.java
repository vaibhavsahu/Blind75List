import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {
    public int minimumTotal(List<List<Integer>> grid) {
        int [][] result = new int[grid.size()][grid.size()];

        result[0][0] = grid.get(0).get(0);

        for(int i = 1; i < grid.size(); i++){
            result[i][0] = result[i-1][0]+grid.get(i).get(0);//first column
            result[i][i] = result[i-1][i-1]+grid.get(i).get(i); //last column
        }

        for(int i = 2; i < grid.size(); i++){
            for(int j = 1; j < i; j++){
                result[i][j] = Math.min(result[i-1][j],
                        result[i-1][j-1])+grid.get(i).get(j);
            }
        }

        return Arrays.stream(result[result.length-1]).min().getAsInt();
    }
}
