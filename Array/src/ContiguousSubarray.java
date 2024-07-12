import java.util.HashMap;

public class ContiguousSubarray {
    public int findMaxLength(int[] nums) {
        int prefixes = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                prefixes += 1;
            } else {
                prefixes -= 1;
            }

            if (map.containsKey(prefixes))
                maxLen = Math.max(maxLen, i-map.get(prefixes)+1);
            if(!map.containsKey(prefixes)) map.put(prefixes, i+1);
        }

        return maxLen;
    }
}
