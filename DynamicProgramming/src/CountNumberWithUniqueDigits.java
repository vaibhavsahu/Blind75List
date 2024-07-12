public class CountNumberWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int global = 10;
        int local = 9;
        for(int i = 2; i <= n; i++){
            local = local*(11-i);
            global += local;
        }
        return global;
    }
}
