import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthMaxInArray {
    public static int thirdMax(int[] nums) {


        Set<Integer> set = new HashSet<>();
        Comparator<Integer> comparator = Comparator.reverseOrder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                queue.add(num);
            }
        }

        if(queue.size() < 3){
            return queue.remove();
        } else {
            int count = 3;
            int currResult = 0;
            while(--count >= 0)
                currResult = queue.remove();
            return currResult;
        }

    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int []{-2147483648,1,1}));
    }
}
