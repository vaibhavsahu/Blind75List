public class FindPivotInteger {
    //https://leetcode.com/problems/find-the-pivot-integer/
    public int pivotInteger(int n) {
        int totalSum = n * (n + 1) / 2;
        int leftSum = 0;

        for(int i = 1; i <= n; i++) {
            leftSum += i;
            if(totalSum - leftSum + i == leftSum) return i;
        }
        return -1;
    }
}
