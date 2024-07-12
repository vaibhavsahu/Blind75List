public class FirstMIssingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int d;
            while(nums[i] != i+1){
                d = nums[i]-1;
                if(d >= 0 && d <= nums.length-1
                        && nums[i] != nums[d]){
                    int temp = nums[i];
                    nums[i] = nums[d];
                    nums[d] = temp;
                } else{
                    break;
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1) return i+1;
        }

        return nums.length+1;
    }
}
