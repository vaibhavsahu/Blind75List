import java.util.*;

public class SlidingWindowMaximum {
    public static int [] slidingMaximum(int [] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            if( i >= k-1){
                res.add(nums[dq.peekFirst()]);
            }
        }
        // Return the result as an array.
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(slidingMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
