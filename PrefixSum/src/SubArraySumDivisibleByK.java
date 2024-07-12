import java.util.HashMap;

public class SubArraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        var prefixMod = 0;
        var result = 0;

        // There are k mod groups 0...k-1.
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for(var num : nums){
            prefixMod = (prefixMod + num % k + k)%k;

            if(map.containsKey(prefixMod)){
                result += map.get(prefixMod);
            }
            map.put(prefixMod, map.getOrDefault(prefixMod, 0)+1);
        }

        return result;
    }
}
