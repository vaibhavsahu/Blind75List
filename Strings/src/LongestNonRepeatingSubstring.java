import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring
        without repeating characters.
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with a length of 3.
*/
public class LongestNonRepeatingSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r,0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
