public class BottomUpFibonacci {
    static int fib(Integer n){
        if(n == 0) return 0;

        int [] result = new int[n+1];
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1]+result[i-2];
        }

        return result[n];
    }
}
