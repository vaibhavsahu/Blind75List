import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DivisiblePermutations {
    /***
     Suppose you have n integers from 1 through n.
     A permutation of those n integers is considered a Divisible Permutation if for every i, where 1 <= i <= n, either of the following is true:
     perm[i] is divisible by i.
     i is divisible by perm[i].

     Given an integer n, find the total number of the valid Divisible Permutations.

     Example 1:
     Input: n = 2
     Output: 2
     Explanation:
     The first Divisible Permutation is [1,2]:
     permutation[1] = 1 is divisible by i = 1
     permutation[2] = 2 is divisible by i = 2

     The second Divisible Permutation is [2,1]:
     permutation[1] = 2 is divisible by i = 1
     i = 2 is divisible by permutation[2] = 1
     */

    public List<List<Integer>> divisiblePermutations(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int [] nums = IntStream.rangeClosed(1, n).toArray();
        helper(0, nums, answer, res);
        return res;
    }

    public void helper(int idx, int[] nums, List<Integer> answer, List<List<Integer>> res) {
        if (idx == nums.length && checkDivisibility(answer)) {
            res.add(new ArrayList<>(answer));
            return;
        }

        for (int j = idx; j < nums.length; j++) {
            swap(nums, j, idx);
            answer.add(nums[idx]);
            helper(idx + 1, nums, answer, res);
            answer.remove(answer.size() - 1);
            swap(nums, j, idx);
        }
    }

    private boolean checkDivisibility(List<Integer> answer) {
        boolean flag1 = true;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) % (i + 1) != 0) {
                flag1 = false;
                break;
            }
        }
        if (!flag1) {
            for (int i = 0; i < answer.size(); i++) {
                if ((i + 1) % answer.get(i) != 0) {
                    flag1 = false;
                    break;

                }
            }
        }
        return flag1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
