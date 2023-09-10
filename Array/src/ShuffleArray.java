public class ShuffleArray {
    //https://leetcode.com/problems/shuffle-the-array/
    public static int[] shuffle(int[] nums, int n) {
        //0,1,2,3,4,5
        //0,3,1,4,2,5
        int[] result = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(shuffle(new int[]{2,5,1,3,4,7}, 3));
    }
}
