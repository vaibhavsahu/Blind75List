import java.util.*;

public class Subsets {

    public static ArrayList<ArrayList<Integer>> getSubsets(int [] nums){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        getSubsetsHelper(0, nums, ans, new ArrayList<>());

        return  ans;

    }

    private static void getSubsetsHelper(int i, int[] nums,
                                         ArrayList<ArrayList<Integer>> ans,
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

    public static void main(String[] args) {
        System.out.println(getSubsets(new int[]{0, -1, -2, -9, 2, 4}));
    }
}
