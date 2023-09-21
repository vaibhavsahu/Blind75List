import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/find-the-losers-of-the-circular-game/
public class FindLosersOfCircularGame {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> vis = new HashSet<>();
        int i = 0, rem = 0;
        //rem has been visited
        do {
            rem = (rem + k * i++) % n;
        } while (vis.add(rem));
        int j = 0;
        int[] res = new int[n - vis.size()];
        for (i = 0; i < n; i++) {
            if (!vis.contains(i)) res[j++] = i + 1;
        }
        return res;
    }
}
