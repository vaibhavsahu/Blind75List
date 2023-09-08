import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/find-resultant-array-after-removing-anagrams
public class ResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if (!curr.equals(prev)) {
                list.add(word);
                prev = curr;
            }
        }
        return list;
    }
}
