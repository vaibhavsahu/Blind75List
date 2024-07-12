import java.util.ArrayList;
import java.util.List;

public class DiffWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, 0, expression.length()-1);
    }

    public List<Integer> helper(String expression, int i, int j){
        int len = j - i + 1;
        List<Integer> result = new ArrayList<>();

        if (len <= 2) {
            result.add(Integer.parseInt(expression.substring(i, i + len)));
            return result;
        }
        for(int idx = i; idx <= j; idx++){
            if(  expression.charAt(idx) == '+'
                    || expression.charAt(idx) == '-'
                    || expression.charAt(idx) == '*'){
                List<Integer> lefts = helper(expression, i, idx-1);
                List<Integer> rights = helper(expression, idx+1, j);
                for(int left : lefts){
                    for(int right: rights){
                        if(expression.charAt(idx) == '+'){
                            result.add(left+right);
                        } else if(expression.charAt(idx) == '-'){
                            result.add(left-right);
                        }else {
                            result.add(left*right);
                        }
                    }
                }
            }
        }
        return result;
    }
}
