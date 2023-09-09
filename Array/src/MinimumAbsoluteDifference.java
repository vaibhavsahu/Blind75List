import java.util.*;
//https://leetcode.com/problems/minimum-absolute-difference/
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++){
            int diff  = arr[i] - arr[i-1];
            minDiff = Math.min(diff, minDiff);
            List<Integer> list = List.of(arr[i-1], arr[i]);
            map.computeIfAbsent(diff, k -> new ArrayList<>()).add(list);
        }

        return map.get(minDiff);
    }
}
