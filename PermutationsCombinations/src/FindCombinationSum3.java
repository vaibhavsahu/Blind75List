import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinationSum3 {
    static void findCombinations(int ind, int[] arr, int k, int target,
                                 List<List<Integer>> ans, List <Integer> ds) {
       // System.out.println("findCombinations " + "( ind: " + ind +", "+ "target: " + target + " )");
        if (target == 0 && ds.size() == k) {
        //    System.out.println(ds);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
           // System.out.println("---inside for loop--");

//            if (arr[i] > target) {
////                System.out.println("arr["+i+"]" + " :  "+ arr[i] + " is greater than:  " +target);
////                System.out.println("breaking from for loop");
//                break;
//            }

            ds.add(arr[i]);
//            System.out.println("after adding to ds list");
//            System.out.println(ds);

            if(target-arr[i] >= 0 || ds.size() <= k){
               // System.out.println("findCombinations " + "( i+1: " + (i + 1) + ", target: " + (target - arr[i]) + " )");
                findCombinations(i + 1, arr, k, target - arr[i], ans, ds);
            }

            ds.remove(ds.size() - 1);
//            System.out.println("after removing from ds list");
//            System.out.println(ds);
//            System.out.println("---exiting for loop--");
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
