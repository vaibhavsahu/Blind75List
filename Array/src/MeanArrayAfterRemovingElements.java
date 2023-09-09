import java.util.Arrays;

public class MeanArrayAfterRemovingElements {

    //https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

    public double trimMean(int[] arr) {

        Arrays.sort(arr);

        int count = (arr.length*5)/100;

        int sum = 0;

        for(int i = count; i < arr.length-count; i++){
            sum+=arr[i];
        }
        return (double)(sum)/(double)(arr.length-2*count);
    }
}
