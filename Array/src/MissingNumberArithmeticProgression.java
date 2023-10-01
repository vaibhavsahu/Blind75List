import java.util.HashSet;
import java.util.Set;

public class MissingNumberArithmeticProgression {
    public static int missingNumber(int[] arr) {
//https://leetcode.com/problems/missing-number-in-arithmetic-progression/

        int first = arr[1] - arr[0];
        int second = arr[2] - arr[1];
        int diff = Math.abs(first) > Math.abs(second) ? second : first;

        for(int i = 1; i < arr.length; i++){
            if(diff != arr[i] - arr[i-1]){
                return arr[i-1] + diff;
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int []{80387,68178,55969,31551}));
    }
}
