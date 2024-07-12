import java.util.*;

public class FlightsRoutesCheckCSES {


    public static void main(String[] args) {
        var input = new Scanner(System.in);

        var firstLine = input.nextLine();
        var firstArr = firstLine.split(" ");
        var inputList = new ArrayList<String>();

        for(var i = 0; i < Integer.parseInt(firstArr[1]); i++){
            inputList.add(input.nextLine());

        }

        var adjMap  = new HashMap<Integer, List<Integer>>();

        for(var inputs : inputList){
            var arr = inputs.split(" ");
            adjMap.computeIfAbsent(Integer.parseInt(arr[0]), k -> new ArrayList<>()).add(Integer.parseInt(arr[1]));
        }

        var adjMapR = new HashMap<Integer, List<Integer>>();

        for(var entry : adjMap.entrySet()){
            for(var value: entry.getValue()){
                adjMapR.computeIfAbsent(value, k -> new ArrayList<>()).add(Integer.valueOf(entry.getKey()));
            }
        }

        var visited = new int[Integer.parseInt(firstArr[0])];
        var parent = new int[Integer.parseInt(firstArr[0])];
        Arrays.fill(visited, -1);
        var result = new ArrayList<Integer>();



        dfs(0, visited, parent, adjMap, result);

        for(var i = 2; i < Integer.parseInt(firstArr[0]); i++){
            if(visited[i] == -1){
                result.add(i);
            }
        }



    }

    public static void dfs(int start, int [] visited, int [] parent,
                       HashMap<Integer, List<Integer>> adjMap, ArrayList<Integer> result) {
        visited[start] = 1;

        for(var neighbor : adjMap.get(start)){
            if(visited[neighbor] == -1){
                dfs(neighbor, visited, parent, adjMap, result);
            }
        }
    }




}
