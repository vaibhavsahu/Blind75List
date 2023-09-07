import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarraySumAtLeastK {


    public static int shortestSubarray(int[] A, int k) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        int ans = N+1;
        Deque<Integer> monoq = new LinkedList<>();

        for (int y = 0; y < P.length; ++y) {
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + k)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int []{2,1,-2,5,2}, 5));
    }
}
