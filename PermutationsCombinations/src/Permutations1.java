import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        helper(0, nums, answer, result);

        return result;
    }

    public void helper(int idx, int[] nums, List<Integer> answer, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(answer));
            return;
        }

        for (var i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            answer.add(nums[idx]);
            helper(idx + 1, nums, answer, result);
            if (!answer.isEmpty())
                answer.remove(answer.size()-1);
            swap(nums, i, idx);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
