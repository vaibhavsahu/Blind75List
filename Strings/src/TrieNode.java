import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean end;

    public TrieNode() {
        this.children = new HashMap<>();
        this.end = false;
    }

}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
       TrieNode curr = root;
        for(char c : word.toCharArray()){
           if(!curr.children.containsKey(c)){
               curr.children.put(c, new TrieNode());
           }
           curr = curr.children.get(c);
       }
        curr.end = true;
    }

    public boolean search(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
       return curr.end;
    }

    public boolean startsWith(String prefix){
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        return true;
    }

    public int countWordsEqualTo(String word) {
        int count = 0;
        if(search(word)){
            count++;
        }
        return count;
    }

//    public int countWordsStartingWith(String prefix) {
//
//    }
//
//    public void erase(String word) {
//
//    }
}
