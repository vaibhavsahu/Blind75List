import java.util.*;

public class ReconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> adjMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            adjMap.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
        }

        adjMap.forEach((key, value) -> Collections.sort(value));

        LinkedList<String> result = new LinkedList<>();

        dfs("JFK", result, adjMap);

        return result;
    }

    public static void dfs(String start, LinkedList<String> result, Map<String, LinkedList<String>> adjMap){
        if (adjMap.containsKey(start)) {
            LinkedList<String> destList = adjMap.get(start);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                dfs(dest, result, adjMap);
            }
        }

        // add the airport to the head of the itinerary
            result.offerFirst(start);
    }


}
