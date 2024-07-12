import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            int remainder = total % k;
            if(!map.containsKey(remainder)){
                map.put(remainder, i);
            } else if( i - map.get(remainder) > 1){
                return true;
            }
        }
        return false;
    }
}
