public class FindPeakElement {

    //array will be unsorted

    public int findPeakElement(int[] nums) {
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
            } else if(  mid +1 <= nums.length -1 && nums[mid+1] > nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return peak;
    }
}
