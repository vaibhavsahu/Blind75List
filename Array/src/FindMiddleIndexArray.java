public class FindMiddleIndexArray {
    //https://leetcode.com/problems/find-the-middle-index-in-array/
    public int findMiddleIndex(int[] nums) {
        int [] leftSum = new int[nums.length];
        int [] rightSum = new int[nums.length];
        leftSum[0]=nums[0];
        rightSum[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        for(int i = nums.length-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1]+ nums[i];
        }


        for(int i=0; i<nums.length;i++){
            if(leftSum[i]==rightSum[i])//checking if index is same or not, if same,
                return i; //return that index
        }
        return -1;


    }
}
