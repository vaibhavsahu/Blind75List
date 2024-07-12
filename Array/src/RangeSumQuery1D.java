import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery1D {
    List<Integer> list = new ArrayList<>();

    public RangeSumQuery1D(int[] nums) {
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            list.add(nums[i]+list.get(i-1));
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return list.get(right);
        return list.get(right)- list.get(left-1);
    }
}
