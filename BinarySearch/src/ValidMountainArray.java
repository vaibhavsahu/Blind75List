//https://leetcode.com/problems/valid-mountain-array
public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {

        int peakIndex = findPeakIndex(arr);

        if(peakIndex == -1
                || peakIndex == 0
                || peakIndex == arr.length-1){
            return false;
        } else {

            for(int i = 0; i < peakIndex-1; i++){
                if(arr[i] >= arr[i+1]){
                    return false;
                }
            }
            for(int i = peakIndex+1; i < arr.length-1; i++){
                if(arr[i+1] >= arr[i]){
                    return false;
                }
            }
            return true;
        }

    }

    public static int findPeakIndex(int [] nums){
        int low = 0;
        int high = nums.length-1;
        int peak = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(low == high){
                return low;
            }

            if(( mid - 1 < 0 && nums[mid] > nums[mid+1])
                    || (mid + 1 > nums.length-1 && nums[mid] > nums[mid-1])
                    ||  (mid - 1 >= 0 && mid +1 <= nums.length -1
                    && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])){
                return mid;
            } else if(  mid +1 <= nums.length -1
                    && nums[mid+1] > nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return peak;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int []{6,7,7,8,6}));
    }
}
