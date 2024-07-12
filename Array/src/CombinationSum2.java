import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    public static void main(String[] args) {
        combinationSum2(new int []{1,2,3,4,4,5}, 10);
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        nums = Arrays.stream(nums).filter(x -> x <= target).toArray();
        combinationSum2Helper(nums, list, result, target, 0);
        return result;
    }

    public static void combinationSum2Helper(int [] nums, List<Integer> list,
                                             List<List<Integer>> resultSet,
                                             int target,  int index){

        if(target == 0){
            resultSet.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++){
//            if( i > index && nums[i] == nums[i-1]){
//                continue;
//            }
            if(nums[i] > target)
                break;
            if( i <= index && nums[i] != nums[i-1]) {

                list.add(nums[i]);
                combinationSum2Helper(nums, list, resultSet,
                        target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
