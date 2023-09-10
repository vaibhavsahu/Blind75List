import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsequenceWithLimitedSum {
//https://leetcode.com/problems/longest-subsequence-with-limited-sum/
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for(var i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }

        int n = queries.length;
        int[] answer = new int[n];
        for (var i = 0; i < n; ++i) {
            var index = binarySearch(nums, queries[i]);
            answer[i] = index;
        }

        return answer;
    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            var mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid + 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left] > target ? left : left + 1;
    }
}
