import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            if(arr[i] != i+1){
                int j = i - 1;
                while (j >= 0) {
                    if (arr[j] == i + 1)
                        break;
                    j--;
                }
                //reverse arr from j to 0
                reverse(arr, 0, j);
                //reverse arr from i to 0
                reverse(arr, 0, i);
                list.add(j+1);
                list.add(i+1);
            }
        }
        return list;
    }

    public void reverse(int [] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
