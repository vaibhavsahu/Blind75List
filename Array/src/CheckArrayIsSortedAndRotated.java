public class CheckArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                count++;
            }
        }
        if(nums[n - 1] > nums[0]){
            count++;
        }
        return count <= 1;
    }
}
