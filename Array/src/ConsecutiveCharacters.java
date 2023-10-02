public class ConsecutiveCharacters {
    //https://leetcode.com/problems/consecutive-characters/
    public int maxPower(String s) {
        int maxLen = 1;
        int right = 0;
        int max = Integer.MIN_VALUE;

        while(right < s.length()-1){
            while(right < s.length()-1 && s.charAt(right) == s.charAt(right+1)){
                maxLen++;
                right++;
            }
            max = Math.max(max, maxLen);
            if(right < s.length()-1 && s.charAt(right) != s.charAt(right+1)){
                maxLen = 1;
                right++;
            }
        }

        return max == Integer.MIN_VALUE ? 1 : max;
    }
}
