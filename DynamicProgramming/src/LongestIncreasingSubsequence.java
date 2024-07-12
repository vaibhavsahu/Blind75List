import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int [] nums){
        int n = nums.length;
        int [][] result = new int[n][n];
        int [] count = new int[n];
        Arrays.fill(count, 1);

        //all diags should be one
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        for (int row = n-2; row >= 0 ; row--) {
            for(int col = row+1; col < n; col++){
                if(nums[row] < nums[col]){
                    result[row][col] = 1 + result[row+1][col-1];
                } else{
                    result[row][col] = Math.max(result[row+1][col], result[row][col-1]);
                }
            }
        }

        int [] len = new int[n];
        System.arraycopy(result[0], 0, len, 0, n);
        for (int i = 0; i < n-1; i++) {
            if(len[i] < len[i+1]){
                len[i] = len[i]+1;
                count[i] = count[i+1];
            } else if (len[i] == len[i+1]) {
                count[i] += count[i+1];
            }
        }

        return result[0][n-1];
    }

    public static void getAllLIS(int[] nums, int [][] result, List<List<Integer>> answer, List<Integer> list){

    }

    public static int countLIS(int [] nums){
        final int n = nums.length;
        int ans = 0;
        int maxLength = 0;
        int[] length = new int[n]; // length[i] := LIS's length ending in nums[i]
        int[] count = new int[n];  // count[i] := the number of the LIS ending in nums[i]

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        // Calculate length and count arrays
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j)
                if (nums[j] < nums[i])
                    if (length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[i] == length[j] + 1) {
                        count[i] += count[j];
                    }

        for (int i = 0; i < n; ++i) {
            if (length[i] > maxLength) {
                maxLength = length[i];
                ans = count[i];
            } else if (length[i] == maxLength) {
                ans += count[i];
            }
        }

        return ans;
    }

    public static int binarySearchLIS(int [] nums){
        int n = nums.length;
        int [] m = new int[n+1];

        Arrays.fill(m, Integer.MAX_VALUE);
        m[0] = Integer.MIN_VALUE;

        int k = 0;
        for (int num : nums) {
            if (num > m[k]) {
                m[++k] = num;
            } else {
                int first = 0;
                int last = k;
                while (last > first + 1) {
                    int mid = (first + last) / 2;
                    if (m[mid] < num) {
                        first = mid;
                    } else {
                        last = mid;
                    }
                }
                m[last] = num;
            }
        }
        return k;
    }
}
