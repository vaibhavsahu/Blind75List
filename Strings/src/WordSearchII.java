import java.util.*;
import java.util.stream.Collectors;

class TrieNodie{
    Map<Character, TrieNodie> children;
    public TrieNodie() {
        this.children = new HashMap<>();
    }
}

public class WordSearchII {
    static int [] idx = {-1, 0,0, 1};
    static int [] idy = {0, -1, 1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        //build trie out of words
        TrieNodie root = new TrieNodie();

        for(String word: words){
            TrieNodie curr = root;
            for(char ch: word.toCharArray()){
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new TrieNodie());
                }
                curr = curr.children.get(ch);
            }
            curr.children.put('$', new TrieNodie());
        }

        Set<String> bag = new HashSet<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++){
                dfs(root, row, col , m, n, board, new StringBuilder(), bag);
            }
        }

        return new ArrayList<>(bag);
    }

    public void dfs(TrieNodie node,  int x,
                    int y, int m, int n,
                    char[][]board, StringBuilder slate,
                    Set<String> bag){

        if(!node.children.containsKey(board[x][y])) return;

        char tempChar = board[x][y];
        slate.append(board[x][y]);

        node = node.children.get(board[x][y]);

        board[x][y] = '.';

        if(node.children.containsKey('$')){
            String temp = slate.toString();
            bag.add(temp);
            node.children.remove('$');
        }

        for(int index = 0; index < idx.length; index++){
            int nx = x+idx[index];
            int ny = y+idy[index];
            if(nx >= 0 && ny >= 0
                    && nx < m
                    && ny < n && board[nx][ny] != '.'){
                dfs(node,  nx, ny , m, n, board, slate, bag);
            }
        }
        board[x][y] = tempChar;
        slate.deleteCharAt(slate.length()-1);
    }
}
