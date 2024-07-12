import java.util.ArrayList;

public class ZombiesClusters {
    static Integer zombie_cluster(ArrayList<String> zombies) {
        int clusters = 0, n = zombies.size();
        boolean[] visited = new boolean[n];

        // Call dfs on any zombie that has not been visited yet.
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                // Any unvisited zombie is a part of a cluster we have not seen until now.
                clusters++;
                // dfs() call will visit *all* zombies in that cluster.
                dfs(i, n, zombies, visited);
            }
        }
        return clusters;
    }

    // Traverse depth first starting from node x, mark all visited nodes visited.
    static void dfs(int x, int n, ArrayList<String> zombies, boolean[] visited) {
        visited[x] = true;
        for(int i = 0; i < n; i++) {
            if(zombies.get(x).charAt(i) == '1' && !visited[i]) {
                dfs(i, n, zombies, visited);
            }
        }
    }

}
