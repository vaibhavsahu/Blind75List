import java.util.*;

public class AlienDictionary {

    Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    Map<Character, Boolean> seen = new HashMap<>();
    StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {
        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (var word : words) {
            for (var c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            var word1 = words[i];
            var word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (var j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // Step 2: DFS to build up the output list.
        for (var c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }

        return output.toString();
    }

    // Return true if no cycles detected.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            var result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}

