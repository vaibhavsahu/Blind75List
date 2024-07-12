import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        int minLen = Math.min(s.length(), p.length());
        for (int i = 0; i < minLen; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        if(sMap.equals(pMap)) result.add(0);
        int k = p.length();

        for (int i = k; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            if (sMap.containsKey(s.charAt(i - k))
                    && sMap.get(s.charAt(i - k)) - 1 == 0) {
                sMap.remove(s.charAt(i - k));
            }
            if (sMap.containsKey(s.charAt(i - k))) sMap.put(s.charAt(i - k), sMap.get(s.charAt(i - k)) - 1);
            if(sMap.equals(pMap)) result.add(i-k+1);
        }
        return result;
    }
}
