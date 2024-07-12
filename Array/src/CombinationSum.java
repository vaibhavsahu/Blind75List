import java.util.ArrayList;
import java.util.stream.Collectors;

public class CombinationSum {
     ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, Integer target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generate_all_combinations_helper(arr, target, 0, list, result);

        return result.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

     void generate_all_combinations_helper(ArrayList<Integer> arr, Integer target, int index,
                                                 ArrayList<Integer> list,  ArrayList<ArrayList<Integer>> result){

  /*       [
[42, 35, 1, 5],
[42, 35, 6],
[42, 1, 37, 3],
[68, 1, 6, 5, 3],
[35, 6, 37, 5],
[35, 43, 5],
[1, 25, 6, 46, 5],
[1, 25, 6, 43, 5, 3],
[1, 25, 3, 54],
[1, 79, 3],
[1, 6, 28, 43, 5],
[1, 6, 43, 28, 5],
[1, 46, 28, 5, 3],
[1, 82],
[1, 28, 54],
[6, 46, 28, 3],
[46, 37],
[43, 37, 3]
]*/



        if(index == arr.size()){
            if(0 == target){
                result.add(new ArrayList<>(list));
            }
            return;
        } else {
            list.add(arr.get(index));
            generate_all_combinations_helper(arr, target- arr.get(index), index+1, list, result);
            list.remove(list.size()-1);
            generate_all_combinations_helper(arr, target, index+1, list, result);
        }
    }
}
