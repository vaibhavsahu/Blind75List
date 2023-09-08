import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-averages/
public class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> s=new HashSet<>();
        for(int i=0,j=nums.length-1;i<j;i++,j--) {
            double avg=(double)(nums[i]+nums[j])/2;
            s.add(avg);
        }
        return s.size();
    }
}
