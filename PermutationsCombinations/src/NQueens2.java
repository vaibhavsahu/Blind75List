import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, n, new ArrayList<>(), result);
        return result.size();

    }

    public void helper(int row, int n, List<Integer> answer, List<List<Integer>> result){
        if(row == n){
            result.add(new ArrayList<>(answer));
            return;
        }

        for(int col = 0; col < n; col++){
            if(validPlace(row, col, n, answer)){
                answer.add(row, col);
                helper(row+1, n, answer, result);
                answer.removeLast();
            }
        }
    }

    public boolean validPlace(int row, int col, int n, List<Integer> answer){
        for(int i = 0; i < row; i++){
            int column = answer.get(i);

            if(column == col || Math.abs(i-row) == Math.abs(col-column)){
                return false;
            }
        }
        return true;
    }
}
