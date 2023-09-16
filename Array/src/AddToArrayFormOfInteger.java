import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/add-to-array-form-of-integer
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int N = num.length;
        int cur = k;
        List<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += num[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}
