import java.util.*;

public class SlidingWindowMaximum {
    public static int [] slidingMaximum(int [] nums, int k) {
        var queue = new LinkedList<Integer>();
        var res = new ArrayList<Integer>();

        for (var i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && k == i - queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            if( i > k){
                res.add(nums[queue.peekFirst()]);
            }
        }
        // Return the result as an array.
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(slidingMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
