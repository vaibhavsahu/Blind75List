import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSquares {
        public List<List<String>> wordSquares(String[] words) {
            int N = words[0].length();
            List<List<String>> results = new ArrayList<>();
            Trie trie = new Trie(words); // build the Trie with all the words

            for (String word : words) {
                // We initialize a partial solution with the current word as top-most word
                // and try to build a word square from that.
                List<String> partialSolution = new ArrayList<>();
                partialSolution.add(word);

                backtrack(1, partialSolution, results, N, words, trie);
            }

            return results;
        }

        private void backtrack(int row, List<String> partialSolution, List<List<String>> completeSolution, int N, String[] words, Trie trie) {
            if (row == N) {
                completeSolution.add(new ArrayList<>(partialSolution));
                return;
            }

            StringBuilder prefix = new StringBuilder();
            for (String word : partialSolution) {
                prefix.append(word.charAt(row));
            }
            List<Integer> suitableCandidates = trie.getWordsWithPrefix(prefix.toString()); // construct suitable candidates
            // Candidate Construction Ends****

            for (Integer wordIndex : suitableCandidates) {
                partialSolution.add(words[wordIndex]); // makeMove
                backtrack(row + 1, partialSolution, completeSolution, N, words, trie); // recursively call backtrack( ... )
                partialSolution.remove(partialSolution.size() - 1); // undoMove
            }
        }
    }

    class TrieNode {

        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        List<Integer> wordList = new ArrayList<>();

        public TrieNode() {}
        public TrieNode(char ch) {
            this.ch = ch;
        }

        public void addWord(String word, int wordIndex) {
            char firstCharacter = word.charAt(0);
            if (!this.children.containsKey(firstCharacter)) {
                this.children.put(firstCharacter, new TrieNode(firstCharacter));
            }
            this.wordList.add(wordIndex);
            if (word.length() > 1) {
                TrieNode nextNode = this.children.get(firstCharacter);
                nextNode.addWord(word.substring(1), wordIndex);
            }
        }

    }

    class Trie{
        TrieNode root = new TrieNode();
        public Trie(String[] words) {
            for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
                root.addWord(words[wordIndex], wordIndex);
            }
        }

        public List<Integer> getWordsWithPrefix(String prefix) {
            // go to the trie node that contains the last character in the prefix
            TrieNode node = root;
            for (Character letter : prefix.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    // return an empty list.
                    return new ArrayList<>();
                }
            }
            // return the wordList stored in the node
            return node.wordList;
        }

}
