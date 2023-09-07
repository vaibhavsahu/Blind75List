import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
        Given the sorted rotated array nums of unique elements,
        return the minimum element of this array.
        You must write an algorithm that runs in O(log n) time.
        Input: nums = [3,4,5,1,2]
        Output: 1
        Explanation: The original array was [1,2,3,4,5] rotated 3 times.
*/
public class MinRotatedSortedArray {
    //four cases
    //min could be leftmost
    //min could be rightmost
    //min could be in left subarray from middle
    //min could be in right subarray from middle
    //min could be middle

    public static int minRotatedSortedArray(int [] arr){
        //6/2 -> 3 -> 1, 2, 3, 4, 5, 6, 7/2 -> 3
        int low = 0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
                int mid = (low + high) / 2;
                if (arr[low] <= arr[mid]) {
                    min = Math.min(min, arr[low]);
                    low = mid + 1;
                } else {
                    min = Math.min(min, arr[mid]);
                    high = mid - 1;
                }
            }
            return min;
        }

public static void main(String[] args) {
    System.out.println(minRotatedSortedArray(new int[]{4,5,1,2,3}));

}

}
