import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty()){
            return true;
        }

        if(map.containsKey(s)){
            return map.get(s);
        }

        for( String str: wordDict){
            if(str.length() > s.length()) continue;
            boolean result = false;
            if(s.startsWith(str)){
                String suffix = s.substring(str.length());
                result = wordBreak(suffix, wordDict);
                map.put(suffix, result);
            }

            if(result){
                return true;
            }

        }
        return false;
    }
}
