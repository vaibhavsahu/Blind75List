public class PaintFence {
    public int numWays(int n, int k) {
        int [] same = new int[n];
        int [] diff = new int[n];
        int [] total = new int[n];

        same[0] = 0;
        diff[0] = k;
        total[0] = k;

        for(int i = 1; i < n; i++){
            same[i] = diff[i-1];
            diff[i] = total[i-1]*(k-1);
            total[i] = same[i]+diff[i];
        }

        return total[n-1];
    }
}
