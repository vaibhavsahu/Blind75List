public class WordDictionary {
        TrieNode root;
        boolean [] globalAns = {false};

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.end = true;
        }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.end;
    }
}
