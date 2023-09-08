/*Given an array of integer nums and an integer target, return indices of the two numbers such that they add up to the target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //map
    // Input: nums = [2,7,11,15], target = 9
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);;
                result[1] = i;
            } else{
                map.put(nums[i], i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }
}
