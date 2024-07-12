public class IntegerBreak {
    public int maxProduct(int n){
        if(n == 2) return 1;

        int [] result = new int[n+1];

        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            int best = 0;
            if(i == n) best = n-1;
            else best = i;

            for (int j = 1; j < i; j++) {
                best = Math.max(best, result[j]*result[i-j]);
            }
            result[i] = best;
        }
        return result[n];
    }
}
