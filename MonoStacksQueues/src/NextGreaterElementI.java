import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int [] nums1 = {2,4}, nums2 = {1,2,3,4};

        System.out.println(Arrays.toString(nextGreaterElementWithMonoStack(nums1, nums2)));
    }

    public static int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], -1);
            for (int j = i + 1; j < nums2.length; j++) {
                if(nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        int [] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static int[] nextGreaterElementWithMonoStack(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var stack = new Stack<Integer>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int [] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
