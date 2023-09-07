import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinationSum2 {
    static void findCombinations(int ind, int[] arr, int target,
                                 List<List<Integer>> ans, List <Integer> ds) {
      //  System.out.println("findCombinations " + "( ind: " + ind +", "+ "target: " + target + " )");
        if (target == 0) {
//            System.out.println("target is now 0");
//            System.out.println(ds);
            ans.add(new ArrayList<>(ds));
//            System.out.println(ans);
//            System.out.println("exiting base case");
            return;
        }

        for (int i = ind; i < arr.length; i++) {
          //  System.out.println("---inside for loop--");
            if (i > ind && arr[i] == arr[i - 1]){
//                System.out.println("-----i----- "+i);
//                System.out.println("-----ind----- "+ind);
//                System.out.println("-----arr[i]----- "+arr[i]);
//                System.out.println("-----arr[i-1]----- "+arr[i-1]);
//                System.out.println("-----------");
                continue;
            }
            if (arr[i] > target) {
//                System.out.println("arr["+i+"]" + " :  "+ arr[i] + " is greater than:  " +target);
//                System.out.println("breaking from for loop");
                break;
            }

            ds.add(arr[i]);
//            System.out.println("after adding to ds list");
//            System.out.println(ds);
           // System.out.println("findCombinations " + "( i+1: " + (i + 1) + ", target: " + (target - arr[i]) + " )");
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
//            System.out.println("after removing from ds list");
//            System.out.println(ds);
//            System.out.println("---exiting for loop--");
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList< >());
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> comb = combinationSum2(arr, 8);
        System.out.println(comb.toString().replace(",", " "));
    }
}
