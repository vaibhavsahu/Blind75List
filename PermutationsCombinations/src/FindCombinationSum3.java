import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinationSum3 {
    static void findCombinations(int ind, int[] arr, int k, int target,
                                 List<List<Integer>> ans, List <Integer> ds) {
        if (target == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            ds.add(arr[i]);
            if(target-arr[i] >= 0 || ds.size() <= k){
                findCombinations(i + 1, arr, k, target - arr[i], ans, ds);
            }
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int [] arr = {1,2,3,4,5,6,7,8,9};
        findCombinations(0, arr, k, target, ans, new ArrayList< >());
        return ans;
    }

    public static void main(String[] args) {

        List<List<Integer>> comb = combinationSum2(3, 7);
        System.out.println(comb.toString().replace(",", " "));
    }
}
