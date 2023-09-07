import java.util.*;

public class FirstNegativeInSubarraySizeK {

    public static int [] firstNegativeInSubarraySizeK(int [] a, int k){
        int n = a.length;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = 0;
       while(right < n){
            if (a[right] < 0) {
                q.add(a[right]);
            }

            if (right - left + 1 == k) { // Calculate result and Slide the window
                if (q.isEmpty()) {
                    list.add(0);
                } else {
                    int num = q.peek();
                    list.add(num);

                    if (num == a[left]) {
                        q.remove();
                    }
                }
                left++; // Slide the window ahead
            }
            right++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstNegativeInSubarraySizeK(new int[]{10, -1, -5, 7, -15, 20, 18, 24}, 3)));
    }
}
