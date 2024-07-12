import java.util.HashMap;
import java.util.Map;

class TrieNod {

    Map<Character, TrieNod> children;
    int end;
    int total;

    public TrieNod() {
        this.children = new HashMap<>();
        this.end = 0;
        this.total = 0;
    }

}

class Triee {
    TrieNod root;
    public Triee(){
        root = new TrieNod();
    }

    public void insert(String word){
        TrieNod curr = root;
        for(char c : word.toCharArray()){
            curr.total++;
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNod());
            }
            curr = curr.children.get(c);
        }
        curr.end += 1;
        curr.total += 1;
    }

    public int countWordsEqualTo(String word) {
        TrieNod curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)) return 0;
            curr = curr.children.get(c);
        }
        return curr.end;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNod curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)) return 0;
            curr = curr.children.get(c);
        }
        return curr.total;
    }

    public void erase(String word) {
        TrieNod curr = root;
        for(char c : word.toCharArray()){
            curr.total--;
            if(curr.children.get(c).total == 1){
                curr.children.remove(c);
                return;
            }
            curr = curr.children.get(c);
        }
        curr.end--;
        curr.total--;
    }
}