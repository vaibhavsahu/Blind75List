import java.util.ArrayDeque;
import java.util.Map;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> minQ = new ArrayDeque<>();
        ArrayDeque<Integer> maxQ = new ArrayDeque<>();

        int left = 0;
        int right = 0;

        int maxLen = Integer.MIN_VALUE;

        while (right < nums.length){
            while(!maxQ.isEmpty() && maxQ.peekLast() < nums[right]){
                maxQ.removeLast();
            }
            maxQ.addLast(nums[right]);
            while(!minQ.isEmpty() && minQ.peekLast() > nums[right]){
                minQ.removeLast();
            }
            minQ.addLast(nums[right]);
            while(left <= right && maxQ.peekFirst() - minQ.peekFirst() > limit){
                if(nums[left] == maxQ.peekFirst()) maxQ.removeFirst();
                if(nums[left] == minQ.peekFirst()) minQ.removeFirst();
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
