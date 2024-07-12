//Leetcode
//https://leetcode.com/problems/combination-sum/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinationSum1 {

    public static void main(String[] args) {
        //candidates = [2,3,6,7], target = 7
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Arrays.sort(candidates);
        List<List<Integer>> result = findCombinationSum1(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> findCombinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum1Helper(0, candidates, target, ans,
                new ArrayList<>());
        return ans;
    }

    private static void findCombinationSum1Helper(int i, int[] candidates,
                                                  int target,
                                                  List<List<Integer>> ans,
                                                  List<Integer> list) {
        if (i == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (candidates[i] <= target) {
            list.add(candidates[i]);
            findCombinationSum1Helper(i, candidates, target - candidates[i],
                    ans, list);
            list.remove(list.size() - 1);
        }
        findCombinationSum1Helper(i + 1, candidates, target, ans, list);

    }
}
