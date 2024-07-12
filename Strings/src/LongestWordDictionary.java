import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestWordDictionary {
    String [] global = {""};
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.end = true;
        for(String word: words){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.end = true;
        }

        helperSB(root, new StringBuilder());
        return global[0];
    }

    public void helperSB(TrieNode node, StringBuilder slate){
        if(!node.end) return;
        String  temp = slate.toString();
        if(temp.length() > global[0].length()
                || (temp.length() == global[0].length() &&
                temp.compareTo(global[0]) < 0)){
            global[0] = temp;
        }
        for(Map.Entry<Character, TrieNode> entry : node.children.entrySet()){
            slate.append(entry.getKey());
            helperSB(node.children.get(entry.getKey()), slate);
            slate.deleteCharAt(slate.length()-1);
        }
    }
}
