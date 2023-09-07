import java.util.HashMap;

public class LongestSubstringWithAtMostKUniqChars {

    public int longestSubstringWithAtMostKUniqChars(String s, int k){
        int n = s.length();
        if (n < k) return n;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> hashmap = new HashMap<>();

        int max_len = k;

        while (right < n) {
            hashmap.put(s.charAt(right), hashmap.getOrDefault(s.charAt(right), 0)+1);
            while (hashmap.size() > k) {
                if(hashmap.containsKey(s.charAt(left))){
                    if(hashmap.get(s.charAt(left)) == 1){
                        hashmap.remove(s.charAt(left));
                    } else {
                        hashmap.put(s.charAt(left), hashmap.get(s.charAt(left)) - 1);
                    }
                }
                left++;
            }

            max_len = Math.max(max_len, right - left+1);
            right++;
        }
        return max_len;
    }

    public static void main(String[] args) {

    }
}
