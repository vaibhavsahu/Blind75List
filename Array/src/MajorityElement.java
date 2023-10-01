import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //https://leetcode.com/problems/majority-element/editorial/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int n = nums.length;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }

        return -1;
    }
}
