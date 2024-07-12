import java.util.*;


/*
If the two words differ by a single letter,
it is possible to transform one word into another.
Given a start word, a target word, and a list of words,
return all possible shortest transformations of the start word to the target word.
Each subsequent word of the transformation must exist in the given list of words.

        Example One
        {
        "start_word": "hot",
        "target_word": "dog",
        "words": ["cat", "dog", "hat", "dot", "cot", "hog"]
        }
        Output:
        [["hot", "hog", "dog"],["hot", "dot", "dog"]]
        "hot" -> "hat" -> "cat" -> "cot" -> "dot" -> "dog" or "hot" -> "cot" -> "dot" -> "dog"
         are also two valid transformation sequences, but they are not shortest.

        Example Two
        {
        "start_word": "hot",
        "target_word": "dog",
        "words": ["cat", "hat", "dot", "cot", "hog"]
        }
        Output: []
*/
public class ShortestTransformationSequences {
    static ArrayList<ArrayList<String>> get_all_shortest_transformation_sequences(String start_word,
                                                                                  String target_word,
                                                                                  ArrayList<String> words) {
        if(!words.contains(target_word)) return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start_word);
        visited.add(start_word);

        while(!queue.isEmpty()){
            String word = queue.remove();
//            for(String neighbor : getNeighbors(word)){
//
//            }

        }






        return new ArrayList<>();
    }

//    public static List<String> getNeighbors(String word, List<String> words){
//        List<String> neighbors = new ArrayList<>();
//
//        for(String wordy : words){
//            int diff = 0;
//            for(int i = 0; i < Math.min(word.length(), wordy.length()); i++){
//                if(word.charAt(i) != wordy.charAt(i)){
//                    diff++;
//                }
//            }
//            if(diff == 1) neighbors.add(wordy);
//        }
//
//
//    }



}
