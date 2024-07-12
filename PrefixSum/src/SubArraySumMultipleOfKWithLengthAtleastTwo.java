import java.util.HashMap;

public class SubArraySumMultipleOfKWithLengthAtleastTwo {
    public boolean checkSubarraySum(int[] nums, int k) {

        var map = new HashMap<Integer, Integer>();
        var prefixSum = 0;

        map.put(0, -1);

        for(var i = 0; i < nums.length; i++){
            prefixSum = (prefixSum + nums[i]) % k;

            if(map.containsKey(prefixSum)){
                if(i - map.get(prefixSum) > 1){
                    return true;
                }
            } else {
                map.put(prefixSum, i);
            }

        }


        return false;
    }
}
