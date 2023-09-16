import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/binary-prefix-divisible-by-5
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        LinkedList<Boolean> ans = new LinkedList<>();

        int sum = 0;
        for(int num: nums){
            sum = (sum * 2 + num) % 5;
            ans.addLast(sum == 0);
        }

        return ans;
    }
}
