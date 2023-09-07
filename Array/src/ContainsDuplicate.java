import java.util.HashSet;
import java.util.Set;

/*Given an integer array nums, return true if any value appears at least twice
 in the array, and return false if every element is distinct.
        Input: nums = [1,2,3,1] Output: true

 */
public class ContainsDuplicate {

    public static boolean isContainsDuplicate(int [] nums){
        var set = new HashSet<>();

        for (int j : nums) {
            if (set.contains(j)) {
                return true;
            } else {
                set.add(j);
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
