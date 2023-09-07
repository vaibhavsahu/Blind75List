import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int []> ans = new ArrayList<>();



        // list.stream().sorted(startComparator.thenComparing(endComparator));
        int i = 0;
        int j = 0;


        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        int idx = 0;
        int [][] resultArr = new int [ans.size()][2];
        for(int [] interval: ans){
            resultArr[idx++] = interval;
        }

        return resultArr;
    }
}
