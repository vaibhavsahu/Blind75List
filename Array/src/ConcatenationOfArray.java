public class ConcatenationOfArray {
    //https://leetcode.com/problems/concatenation-of-array/
    public int[] getConcatenation(int[] nums) {
        int [] ans = new int[nums.length*2];

        for(int i = 0; i < ans.length; i++){
            if(i >= nums.length){
                ans[i] = nums[i-nums.length];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}
