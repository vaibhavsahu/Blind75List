import java.util.Arrays;

public class FirstLastOccurrenceOfElementSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int [] result = new int[2];


        Arrays.fill(result, -1);

        result[0] = findFirstIndex(nums, target);
        result[1] = findLastIndex(nums, target);

        return result;
    }

    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int idx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target ) {
                low = mid - 1;
            } else {
                high = mid + 1;
            }

            if (nums[mid] == target) idx = mid;

        }
        return idx;
    }

    private int findLastIndex(int[] nums, int target) {

            int low = 0;
            int high = nums.length-1;

            int idx = -1;

            while(low <= high){
                int mid = (low+high)/2;

                if(nums[mid] <= target){
                    high = mid-1;
                } else {
                    low = mid+1;
                }

                if(nums[mid] == target) idx = mid;

            }
            return idx;
    }


}
