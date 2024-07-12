import java.util.Arrays;

public class CountWellFormedParanthesis {
    public int countWellFormedParanthesis(int n){
        int [] result = new int[n+1];
        Arrays.fill(result, 1);

        result[0] = 1;

        for (int p = 1; p <= n; p++) {
            for (int i = 0; i < p; i++) {
                result[p] += result[i]*result[p-i-1];
            }
        }
        return result[n];
    }
}
