import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElementIIWithMonoStack(new int[]{1,2,3,4,3})));
    }
    public static int[] nextGreaterElementIIBruteForce(int[] nums) {
        int n = nums.length;
        int [] nums1 = new int[2*n];
        System.arraycopy(nums,0,nums1,0,n);
        System.arraycopy(nums,0,nums1,n,n);
        var map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],-1);
            for(int j = i+1; j < nums1.length; j++){
                if(nums1[j] > nums1[i]){
                    map.put(nums[i], nums1[j]);
                    break;
                }
            }
        }
        int []res = new int[n];
        for(int i = 0; i < nums.length; i++){
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public static int[] nextGreaterElementIIWithMonoStack(int[] nums) {
        int n = nums.length;
        int [] nums1 = new int[2*n];
        System.arraycopy(nums,0,nums1,0,n);
        System.arraycopy(nums,0,nums1,n,n);
        var map = new HashMap<Integer,Integer>();
        var stack = new Stack<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            int index = i%n;
            while(!stack.isEmpty() && stack.peek() < nums[index]){
                map.put(stack.pop(),nums[index]);
            }
            stack.push(nums[index]);
        }


        int []res = new int[n];
        for(int i = 0; i < nums.length; i++){
            res[i] = map.getOrDefault(nums[i], -1);
        }
        return res;
    }
}
