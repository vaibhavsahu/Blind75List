import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> getSubsets(int [] nums){

        List<List<Integer>> ans = new ArrayList<>();

        getSubsetsHelper(0, nums, ans, new ArrayList<Integer>());

        return  ans;

    }

    private static void getSubsetsHelper(int i, int[] nums,
                                         List<List<Integer>> ans,
                                         ArrayList<Integer> list) {
        //base case
        if(nums.length == i){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        getSubsetsHelper(i+1, nums, ans, list);
        list.remove(list.size()-1);
        getSubsetsHelper(i+1, nums, ans, list);
    }
}
