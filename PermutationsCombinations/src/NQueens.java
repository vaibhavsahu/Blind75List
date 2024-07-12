import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solveNQueensHelper(0, n, list, result);
        return result;
    }

    public static void solveNQueensHelper(int index, int n,
                                   List<Integer> list, List<List<String>> result){
        // for loop
        if(!list.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>(list);
            int lastIndex = temp.size()-1;
            for(int i = 0; i < temp.size()-1; i++){
                if(Objects.equals(temp.get(i), temp.get(lastIndex))) return;
                int rowDiff = Math.abs(i-lastIndex);
                int colDiff = Math.abs(temp.get(i)-temp.get(lastIndex));
                if(rowDiff == colDiff) return;
            }
        }

        if(index == n){
            List<String> ans = new ArrayList<>();
            for (Integer integer : list) {
//                StringBuilder sb = new StringBuilder();
//                sb.repeat('.', n);
//                sb.setCharAt(integer, 'Q');
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[integer] = 'Q';
                ans.add(String.valueOf(arr));
            }
            result.add(ans);
            return;
        } else {
            for(int col = 0; col < n; col++){
                list.add(col);
                solveNQueensHelper(index+1, n, list, result);
                list.remove(list.size()-1);
            }
        }
    }
}
