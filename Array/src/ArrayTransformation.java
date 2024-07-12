import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTransformation {
    //https://leetcode.com/problems/array-transformation/
    //1243. Array Transformation
    public static List<Integer> transformArray(int[] arr) {
        int []  copy;

        do {
            copy = Arrays.copyOf(arr, arr.length);
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] > arr[j - 1] && arr[j] > arr[j + 1]) {
                    --arr[j];
                } else if (arr[j] < arr[j - 1] && arr[j] < arr[j + 1]) {
                    ++arr[j];
                }
            }
        }while(!Arrays.equals(copy, arr));

        return Arrays.stream(arr)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(transformArray(new int []{2,1,2,1,1,2,2,1}));
    }


}
