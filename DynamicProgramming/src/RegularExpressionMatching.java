public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();

       StringBuilder sb = new StringBuilder();
        if(!p.isEmpty()){
            sb.append(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if(p.charAt(i) == '*'){
                    int lastIndex = sb.length()-1;
                    if(sb.charAt(lastIndex) == '.'){
                        sb.setCharAt(lastIndex, '*');
                    } else{
                        char ch = Character.toUpperCase(sb.charAt(lastIndex));
                        sb.setCharAt(lastIndex, ch);
                    }
                } else {
                    sb.append(p.charAt(i));
                }
            }
            p = new String(sb);
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
