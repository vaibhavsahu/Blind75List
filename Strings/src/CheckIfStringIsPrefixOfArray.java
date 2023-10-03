public class CheckIfStringIsPrefixOfArray {
    //https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
    public boolean isPrefixString(String s, String[] words) {
        String str = "";
        for(String word: words){
            str += word;
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }
}
