import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;

        while(right < fruits.length){
            baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0)+1);
            while(left <= right && baskets.size() > 2){
                baskets.put(fruits[left], baskets.get(fruits[left])-1);
                if(baskets.get(fruits[left]) == 0) baskets.remove(fruits[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
