import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//https://leetcode.com/problems/decompress-run-length-encoded-list/
public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length/2; i++){
            int frq = nums[2*i];
            int elem = nums[2*i+1];
            int idx = 0;
            while(idx++ < frq){
                list.add(elem);
            }
        }
        return list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
