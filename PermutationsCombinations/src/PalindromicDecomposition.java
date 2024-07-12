import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromicDecomposition {
    static ArrayList<String> generate_palindromic_decompositions(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        helper(s,  result, list, 0);
        return result;
    }

    private static void helper(String s,
                                                                  ArrayList<String> result,
                                                                  ArrayList<String> list, int index) {
        if(index == s.length()){
            String str = String.join("|", list);
                result.add(str);
            return;
            } else {
            for(int j = index; j < s.length(); j++){
                if(isPalindrome(s, index, j)){
                    list.add(s.substring(index, j+1));
                    helper(s, result, list, j+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if (end-start+1 == 1) return true;
        else {
            String str = s.substring(start, end+1);
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
