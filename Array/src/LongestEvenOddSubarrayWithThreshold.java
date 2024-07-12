public class LongestEvenOddSubarrayWithThreshold {

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int answer = 0, right = 0, left = 0;

        while(right < nums.length){
            if(nums[right] > threshold) {
                right++;
                continue;
            }
            left = right;
//            while( right < nums.length - 1
//                    && nums[right] <= threshold &&
//                    ((nums[right - 1] % 2 == 0 && nums[right] % 2 != 0)
//                            || (nums[right + 1] % 2 != 0 && nums[right] % 2 == 0))){
            while (right < nums.length-1 &&
                    nums[right] % 2 != nums[right+1] % 2
                    && nums[right] <= threshold){
                right++;
            }
            answer = Math.max(answer, right - left +1);
            right++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestAlternatingSubarray(new int []{3,2,5,4}, 5));
    }
}
