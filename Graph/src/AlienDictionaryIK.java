import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionaryIK {

    //"words": ["baa", "abcd", "abca", "cab", "cad"]

    //Output: "bdac"
    static String find_order(ArrayList<String> words) {

        Map<Character, List<Character>> adjMap = new HashMap<>();

        for (int i = 0; i < words.size()-1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i+1);

            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                if(word1.charAt(j) != word2.charAt(j)){
                    adjMap.computeIfAbsent(word1.charAt(j), k -> new ArrayList<>()).add(word2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Character> parentMap = new HashMap<>();
        Map<Character, Integer> arrMap = new HashMap<>();
        Map<Character, Integer> depMap = new HashMap<>();

        ArrayList<Character> result = new ArrayList<>();

        List<Character> keys = new ArrayList<>(adjMap.keySet());
        Set<Character> visited = new HashSet<>();
        for (Character key : keys) {
            if (!visited.contains(key)) {
                if (dfs(key, visited, parentMap, arrMap, depMap, result, adjMap)) return "";
            }
        }
        Collections.reverse(result);
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static boolean dfs(Character character, Set<Character> visited,
                               Map<Character, Character> parentMap,
                               Map<Character, Integer> arrMap,
                               Map<Character, Integer> depMap,
                               ArrayList<Character> result,
                               Map<Character, List<Character>> adjMap) {

        visited.add(character);
        arrMap.put(character, arrMap.getOrDefault(character, 0)+1);

        for(char ch: adjMap.getOrDefault(character, new ArrayList<>())){
            if(!visited.contains(ch)){
                parentMap.put(ch, character);
                boolean res = dfs(ch, visited, parentMap, arrMap, depMap, result, adjMap);
                if(res) return  true;
            } else {
                if(parentMap.get(ch) != character && depMap.getOrDefault(ch, 0) == 0) return true;
            }
        }

        depMap.put(character, arrMap.getOrDefault(character, 0)+1);
        result.add(character);
        return false;
    }

}
