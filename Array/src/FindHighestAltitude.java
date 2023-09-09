import java.util.Arrays;

//https://leetcode.com/problems/find-the-highest-altitude/
public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int [] alts = new int[gain.length+1];

        for(int i = 1; i < alts.length; i++){
            alts[i] = gain[i-1] + alts[i-1];
        }

        return Arrays.stream(alts).max().getAsInt();
    }
}
