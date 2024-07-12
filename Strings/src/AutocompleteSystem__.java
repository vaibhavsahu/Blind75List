import java.util.*;
import java.util.stream.Collectors;

class TrieNodee{
    boolean end;
    Map<Character, TrieNodee> children;

    int freq;

    public TrieNodee(){
        this.children = new HashMap<>();
        this.end = false;
        this.freq = 0;
    }
}
public class AutocompleteSystem__ {
    TrieNodee root;
    TrieNodee whereami;

    public AutocompleteSystem__(){
        root = new TrieNodee();
        whereami = root;
    }

    public AutocompleteSystem__(String[] sentences, int[] times) {

        for (int i = 0; i < sentences.length; i++) {
            TrieNodee curr = root;
            for (int j = 0; j < sentences[i].length(); j++) {
                char ch = sentences[i].charAt(j);
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new TrieNodee());
                }
                curr = curr.children.get(ch);
            }
            curr.end = true;
            curr.freq += times[i];
        }
    }

    public List<String> input(char c) {
        List<Character> prefix = new ArrayList<>();
        //base case, end of search
        if(c == '#'){
            whereami.freq += 1;
            whereami.end = true;
            prefix = new ArrayList<>();
            whereami = root; //set back to root, after current search ends
            return new ArrayList<>();
        } else{
            //find its place in trie
            if(!whereami.children.containsKey(c)){
                whereami.children.put(c, new TrieNodee());
            }
            prefix.add(c);
            whereami = whereami.children.get(c);

            List<String> answer = new ArrayList<>();
            Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (Objects.equals(a.getValue(), b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));

            helper(queue, whereami, prefix);

            for (int i = 0; i < Math.min(3, queue.size()); i++) {
                answer.add(queue.remove().getKey());
            }

            return answer;

        }
    }

    public void helper(Queue<Map.Entry<String, Integer>> queue,
                                 TrieNodee node,
                                 List<Character> prefix){

        if(node.end){
            List<Character> list = new ArrayList<>(prefix);
            String str = list.stream().map(Object::toString).collect(Collectors.joining());
            queue.add(new AbstractMap.SimpleEntry<>(str, node.freq+1));
            if(queue.size() > 3) queue.remove();
        }

        for(char ch: node.children.keySet()){
            prefix.add(ch);
            helper(queue, node.children.get(ch), prefix);
            prefix.remove(prefix.size()-1);
        }
    }
}
