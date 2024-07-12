import java.util.*;
import java.util.stream.Collectors;

public class NChooseK {
    public static  ArrayList<ArrayList<Integer>> nChoosek(int n, int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        nChoosekHelper(n, list, result, k, 1);
        System.out.println(result);
        return result;
    }

    private static void nChoosekHelper(int n, LinkedList<Integer> list,
                                       ArrayList<ArrayList<Integer>> result, int k, int start) {
        if(list.size() == k){
            ArrayList<Integer> ans = new ArrayList<>(list);
            if(!result.contains(ans)) result.add(ans);
            return;
        } else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                nChoosekHelper(n, list, result, k, i+1);
                list.removeLast();
            }
        }
    }
}
