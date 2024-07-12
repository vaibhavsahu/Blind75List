import java.util.HashMap;

public class MaxLenSubArrayWithEquals0s1s {
    public int findMaxLength(int[] nums) {
        int prefixes = 0;
        int maxLen = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 0);

        for(var i = 0; i < nums.length; i++){
            if(nums[i] == 1) prefixes++;
            else prefixes--;

            if(map.containsKey(prefixes)){
                maxLen = Math.max(maxLen, i-map.get(prefixes)+1);
            } else {
                map.put(prefixes, i+1);
            }
        }

        return maxLen;
    }
}
