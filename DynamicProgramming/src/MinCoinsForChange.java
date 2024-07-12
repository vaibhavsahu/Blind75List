import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinCoinsForChange {
    static int minChange(ArrayList<Integer> coins, int value){
        int [] result = new int[value+1];

        Arrays.fill(result, Integer.MAX_VALUE);
        Collections.sort(coins);
        result[0] = 0;
        for (int i = 1; i <= value; i++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i-coin >= 0){
                    int val = Math.min(result[i-1], result[i-coin])+1;
                    min = Math.min(min, val);
                }
            }
            result[i] = min;
        }
        return result[value];
    }
}
