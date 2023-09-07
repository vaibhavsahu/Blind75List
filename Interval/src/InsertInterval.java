import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //insert the newInterval in the list of intervals
        //based on sorted start time
        List<int []> sortedIntervals = new ArrayList<>();


        // sortedIntervals.add(previousInterval);

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            sortedIntervals.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            // int [] interval = new int[2];
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        sortedIntervals.add(newInterval);

        while(i < intervals.length){
            sortedIntervals.add(intervals[i]);
            i++;
        }

       int [][] resultArray = new int[sortedIntervals.size()][2];

        for (int j = 0; j < sortedIntervals.size(); j++) {
            resultArray[j] = sortedIntervals.get(j);
        }

        return resultArray;
    }
}
