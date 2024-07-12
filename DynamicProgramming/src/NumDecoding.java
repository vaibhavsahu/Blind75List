import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumDecoding {
    public int numDecodings(String s) {
        int n = s.length();
        int [] result = new int[n+1];
        Set<Character> set = new HashSet<>(List.of('7', '8', '9'));

        result[0] = 1;
        result[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= n; i++){
            if(s.charAt(i-1) != '0') result[i] += result[i-1];

            if(s.charAt(i-2) == '1' ||
                    (s.charAt(i-2) == '2' &&
                            !set.contains(s.charAt(i-1)))){
                result[i] += result[i-2];
            }
        }
        return result[n];
    }
}
