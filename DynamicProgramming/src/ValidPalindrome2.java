public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
