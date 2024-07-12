import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesisHelper(n, n, new StringBuilder(""), result);
        return result;
    }

    public void generateParenthesisHelper(int left, int right,
                                          StringBuilder sb, List<String> result){
        if(left > right) return;

        if(left == 0 && right == 0){
            result.add(new String(sb));
            return;
        } else {
            if(left > 0){
                generateParenthesisHelper( left-1, right, sb.append('('), result);
                sb.deleteCharAt(sb.length()-1);
            }

            if(right > 0){
                generateParenthesisHelper(left, right-1, sb.append(')'), result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
