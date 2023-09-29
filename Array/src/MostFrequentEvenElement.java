import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    //https://leetcode.com/problems/most-frequent-even-element/
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            if(num % 2 == 0 && num != 0){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }

        int max = Integer.MIN_VALUE;

        if(!map.isEmpty()){
            max = Collections.max(map.values());
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                min = Math.min(min, entry.getKey());
            }
        }

        return min;
    }
}
