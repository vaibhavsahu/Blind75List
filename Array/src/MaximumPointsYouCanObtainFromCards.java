import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;

        int L = cardPoints.length-k;
        for (int i = 0; i < L; i++) {
            total+=cardPoints[i];
        }

        int min = Integer.MAX_VALUE;

        for (int i = L; i < cardPoints.length; i++) {
            total += cardPoints[i]-cardPoints[i-L];
            min = Math.min(total, min);
        }
        return Arrays.stream(cardPoints).sum() - min;
    }
}
