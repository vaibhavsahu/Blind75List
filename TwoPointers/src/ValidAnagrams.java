public class ValidAnagrams {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\W", "");

        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if( Character.isLetterOrDigit(s.charAt(left)) && Character.isAlphabetic(s.charAt(right))
                    && s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       // System.out.println(isPalindrome());
    }
}
