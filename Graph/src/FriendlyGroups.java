import java.util.*;

public class FriendlyGroups {
    /*
    Friendly Groups
    There are n people living in a town. Some of them dislike each other.
    Given the value of n and two equal length integer arrays called dislike1 and dislike2.
    For each i in [0, dislike1_size - 1], the person dislike1[i] dislikes the person dislike2[i].
    Check if we can divide the people of the town into two sets such that each person belongs
    to exactly one set and no two persons disliking each other belong to the same set.

    Example One
    {
        "num_of_people": 5,
        "dislike1": [0, 1, 1, 2, 3],
        "dislike2": [2, 2, 4, 3, 4]
    }
    The people can be partitioned into two sets [0, 1, 3] and [2, 4].

    {
"num_of_people": 4,
"dislike1": [0, 0, 0, 1, 2],
"dislike2": [1, 2, 3, 2, 3]
}
Cannot be partitioned into two groups


*/

    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < dislike1.size(); i++) {
            adjMap.computeIfAbsent(dislike1.get(i), k -> new ArrayList<>()).add(dislike2.get(i));
            adjMap.computeIfAbsent(dislike2.get(i), k -> new ArrayList<>()).add(dislike1.get(i));
        }

        int [] visited = new int[num_of_people];
        int [] parent = new int[num_of_people];
        int [] distance = new int[num_of_people];

        Arrays.fill(visited, -1);
        Arrays.fill(parent, -1);

        for(int i = 0; i < num_of_people; i++){
            if(visited[i] == -1){
                if(!bfsBipartite(i, distance, visited, adjMap, parent)) return false;
            }
        }

        return true;
    }


    static boolean bfsBipartite(int source, int [] distance, int [] visited, Map<Integer, List<Integer>> adjMap, int [] parent){
        visited[source] = 1;
        distance[source] = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while(!queue.isEmpty()){
            int node = queue.remove();

            for(int neighbor : adjMap.getOrDefault(node, new ArrayList<>())){
                if(visited[neighbor] == -1){
                    parent[neighbor] = node;
                    visited[neighbor] = 1;
                    distance[neighbor] = distance[node]+1;
                    queue.add(neighbor);
                } else {
                    if(parent[node] != neighbor && distance[neighbor] == distance[node]){
                        return false; //odd length cycle detected, and there is a back edge
                    }
                }
            }
        }
        return true; //graph is bipartite
    }

    static boolean dfsBipartite(int source, int [] distance, int [] visited, Map<Integer, List<Integer>> adjMap, int [] parent){
        visited[source] = 1;
        distance[source] = 1;

            for(int neighbor : adjMap.getOrDefault(source, new ArrayList<>())){
                if(visited[neighbor] == -1){
                    parent[neighbor] = source;
                    distance[neighbor] = distance[source]+1;
                    boolean result = dfsBipartite(neighbor, distance, visited, adjMap, parent);
                    if(!result) return false;
                } else {
                    if(parent[source] != neighbor && distance[neighbor] == distance[source]){
                        return false; //odd length cycle detected, and there is a back edge
                    }
                }
            }

        return true; //graph is bipartite
    }
}
