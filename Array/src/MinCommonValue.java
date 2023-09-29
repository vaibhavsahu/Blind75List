import java.util.HashSet;
import java.util.Set;

public class MinCommonValue {
    //https://leetcode.com/problems/minimum-common-value/
    public int getCommon(int[] nums1, int[] nums2) {
        int minValue = Integer.MAX_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int j : nums1) set.add(j);

        for (int j : nums2) {
            if (set.contains(j))
                minValue = Math.min(minValue, j);
        }

        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }
}
