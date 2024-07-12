import java.util.ArrayList;
import java.util.List;

public class NChooseK {
    public static List<List<Integer>> combinations(int n , int k){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationsHelper(n, k, list, result, 1);
        System.out.println(result);
        return result;
    }

    private static void combinationsHelper(int n, int k, List<Integer> list, List<List<Integer>> result, int index) {
        if(index == n+1 || list.size() == k){
            if(list.size() == k){
                result.add(new ArrayList<>(list));
            }
           return;
        } else {
            //include
            list.add(index);
            combinationsHelper(n, k, list, result, index+1);
            list.remove(list.size()-1);

            //exclude
            combinationsHelper(n, k, list, result, index+1);
        }
    }
}
