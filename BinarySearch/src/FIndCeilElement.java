public class FIndCeilElement {

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int res = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 8, 10, 12, 14}, 5));
    }
}
