public class CountUniqueBSTs {
    public int numTrees(int n) {
        int [] result = new int[n+1];
        result[0] = 1;

        for(int p = 1; p <= n; p++){
            for(int i = 1; i <= p; i++){
                result[p] += (result[i-1]*result[p-i]);
            }
        }
        return result[n];
    }
}
