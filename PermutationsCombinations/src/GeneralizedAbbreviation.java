import java.util.ArrayList;
import java.util.List;


public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        backtrack(result, word, 0, new StringBuilder(), 0);

        return result;
    }

    void backtrack(List<String> result, String word, int position, StringBuilder cur, int count) {

        if (word.length() == position) {
            result.add(cur.append(count > 0 ? count+"" : "").toString());
            return;
        }

        backtrack(result, word, position + 1, new StringBuilder(cur), count + 1);
        cur.append(count > 0 ? count+"" : "").append(word.charAt(position));
        backtrack(result, word, position + 1, new StringBuilder(cur), 0);
        cur.setLength(cur.length() - (count > 0 ? (count+"").length() : 0) - 1);
    }
}
