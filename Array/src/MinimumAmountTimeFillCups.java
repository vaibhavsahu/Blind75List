import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/description/
public class MinimumAmountTimeFillCups {
    public int fillCups(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : nums){
            if(num != 0)
                queue.add(num);
        }

        int count = 0;

        while(!queue.isEmpty() && queue.size() > 1){
            int first = queue.remove();
            int second = queue.remove();
            count++;
            if(first - 1 > 0){
                queue.add(first-1);
            }
            if(second - 1 > 0){
                queue.add(second-1);
            }
        }

        if(queue.size() == 1){
            count += queue.remove();
        }

        return count;
    }
}
