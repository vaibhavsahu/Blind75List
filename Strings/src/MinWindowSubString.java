import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

    public String minWindowSubstring(String s, String t){
        if(s.isEmpty() || t.isEmpty()){
            return "";
        }
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int maxLenSoFar = 0;
        int maxSubLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        String substring = "";
        while(right++ <= s.length()){
            char curr = s.charAt(right);
            sMap.put(curr, sMap.getOrDefault(curr, 0)+1);

            if(sMap.getOrDefault(curr, 0) <=
                    tMap.getOrDefault(curr, 0)){
                maxLenSoFar++;
            }

            while(left++ < right && maxLenSoFar == t.length()){

                if(right-left +1 < maxSubLen){
                    maxSubLen = Math.min(maxSubLen, right-left+1);
                    substring = s.substring(left, right+1);
                }

                char leftChar = s.charAt(left);

                if(sMap.getOrDefault(leftChar, 0) == 1){
                    sMap.remove(leftChar);
                } else {
                    sMap.put(leftChar, sMap.getOrDefault(leftChar, 0)-1);
                }

                if(sMap.getOrDefault(leftChar, 0) <
                        tMap.getOrDefault(leftChar, 0)){
                    maxLenSoFar--;
                }
            }
        }
        return substring;
    }

}
