import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int [][] merge(int [][] intervals){
        if(intervals.length == 1){
            return intervals;
        }

        Comparator<int []> comparator = Comparator.comparing(ints ->
                ints[0]);

        Arrays.sort(intervals, comparator);
        List<int []> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] <= end ){
                end = Math.max(intervals[i][1], end);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});

        int [][] updatedIntervals = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            updatedIntervals[i] = list.get(i);
        }
        return updatedIntervals;
    }
}
