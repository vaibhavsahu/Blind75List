import java.util.*;
//https://leetcode.com/problems/sentence-similarity
public class SentenceSimilarity {
    public static boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : pairs) {
            map.computeIfAbsent(p.get(0), k -> new HashSet<>()).add(p.get(1));
            map.computeIfAbsent(p.get(1), k -> new HashSet<>()).add(p.get(0));
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i])) return false;
            if (!map.get(words1[i]).contains(words2[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String [] sentence1 = {"great","acting","skills"};
        String [] sentence2 = {"fine","painting","talent"};
        List<List<String>> similarPairs = List.of(List.of("great","fine"),
                List.of("drama","acting"),
                List.of("skills","talent"));
        System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));
    }
}
