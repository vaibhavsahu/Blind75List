import java.util.Comparator;
import java.util.PriorityQueue;

public class FindClosestNumberToZero {
    //https://leetcode.com/problems/find-closest-number-to-zero/description/
    public int findClosestNumber(int[] nums) {
    Comparator<Integer> comparator = Comparator.comparing(Math::abs);

    PriorityQueue<Integer> queue = new PriorityQueue<>(comparator.thenComparing(a -> -a));

        for(int num : nums){
            queue.add(num);
        }

        return queue.peek();
    }
}
