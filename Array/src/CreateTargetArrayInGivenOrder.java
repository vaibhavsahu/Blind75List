import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/create-target-array-in-the-given-order/1389. Create Target Array in the Given Order
public class CreateTargetArrayInGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> arr= new ArrayList<>();

        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr.add(index[i],nums[i]);
        }
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}
