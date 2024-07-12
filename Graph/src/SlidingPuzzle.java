import java.util.*;
import java.util.stream.Collectors;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Map<Pair<String, String>, Integer> visited = new HashMap<>();
        LinkedList<Pair<String, String>> queue =
                new LinkedList<>();

        var goal = new Pair<>(
                arrToString(new int[]{1, 2, 3}),
                arrToString(new int[]{4, 5, 0}));

        queue.add(new Pair<>(arrToString(new int[]{board[0][0], board[0][1], board[0][2]}),
                arrToString(new int[]{board[1][0], board[1][1], board[1][2]})));

        visited.put((new Pair<>(arrToString(new int[]{board[0][0], board[0][1], board[0][2]}),
                arrToString(new int[]{board[1][0], board[1][1], board[1][2]}))), 0);


        while (!queue.isEmpty()){
            var entry = queue.remove();
            for(var neighbor : getNeighbors(entry)){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, 1+visited.get(entry));
                    queue.add(neighbor);
                }
            }
        }
        return visited.getOrDefault(goal, -1);
    }

    public List<Pair<String, String>> getNeighbors(Pair<String, String> state){
        List<Pair<String, String>> neighbors = new ArrayList<>();
        char a = state.first.charAt(0);
        char b = state.first.charAt(1);
        char c = state.first.charAt(2);
        char x = state.second.charAt(0);
        char y = state.second.charAt(1);
        char z = state.second.charAt(2);
        if(a == '0'){
            neighbors.add(new Pair<>(String.valueOf(new char[] {b, a, c}), String.valueOf(new char[]{x, y, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[] {x, b, c}), String.valueOf(new char[] {a, y, z})));
        } else if (b == '0') {
            neighbors.add(new Pair<>(String.valueOf(new char[]{b, a, c}), String.valueOf(new char[]{x, y, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, c, b}), String.valueOf(new char[]{x, y, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, y, c}), String.valueOf(new char[]{x, b, z})));
        } else if (c == '0') {
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, c, b}), String.valueOf(new char[]{x, y, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, z}), String.valueOf(new char[]{x, y, c})));
        } else if ( x == '0') {
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, c}), String.valueOf(new char[]{y, x, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{x, b, c}), String.valueOf(new char[]{a, y, z})));
        } else if (y == '0') {
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, c}), String.valueOf(new char[]{y, x, z})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, c}), String.valueOf(new char[]{x, z, y})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, y, c}), String.valueOf(new char[]{x, b, z})));
        } else  {
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, c}), String.valueOf(new char[]{x, z, y})));
            neighbors.add(new Pair<>(String.valueOf(new char[]{a, b, z}), String.valueOf(new char[]{x, y, c})));
        }
        return neighbors;
    }

    public String arrToString(int[] arr){
        return  Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining());
    }
}
