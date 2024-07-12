import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();

        List<Character> list = new ArrayList<>();
        if(!p.isEmpty()){
            list.add(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if(p.charAt(i) == '*'){
                    //int lastIndex = list.size()-1;
                    if(list.get(i-1) == '.'){
                        list.set(i-1, '*');
                    } else{
                        list.set(i-1, Character.toUpperCase(list.get(i-1)));
                    }
                } else {
                    list.add(p.charAt(i));
                }
            }
            p = list.stream().map(Object::toString).collect(Collectors.joining());
        }

        int n = p.length();

        boolean[][] result = new boolean[m+1][n+1];

        result[0][0] = true;

        for(int col = 1; col <= n; col++){
            if(p.charAt(col-1) == '.' || Character.isLowerCase(p.charAt(col-1))) break;
            result[0][col] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    result[i][j] = result[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    result[i][j] = result[i-1][j] || result[i][j-1];
                } else if (Character.isUpperCase(p.charAt(j-1))) {
                    if(s.charAt(i-1) == Character.toLowerCase(p.charAt(j-1))){
                        result[i][j] = result[i-1][j] || result[i][j-1];
                    } else{
                        result[i][j] = result[i][j-1];
                    }
                }
            }
        }
        return result[m][n];
    }
}
