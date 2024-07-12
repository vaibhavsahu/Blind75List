import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationInSubstring {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i),
                    s1Map.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }

        if(s1Map.equals(s2Map)) return true;
        int k  = s1.length();

        for(int i = k; i < s2.length(); i++){
            if(s2Map.containsKey(s2.charAt(i-k))
                    && s2Map.get(s2.charAt(i-k))-1 == 0){
                s2Map.remove(s2.charAt(i-k));
            }
            if(s2Map.containsKey(s2.charAt(i-k))) s2Map.put(s2.charAt(i-k), s2Map.get(s2.charAt(i-k))-1);

            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
            if(s1Map.equals(s2Map)) return true;
        }
        return false;
    }
}
