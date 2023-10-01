public class GetMaxInGeneratedArray {
    public int getMaximumGenerated(int n) {
//https://leetcode.com/problems/get-maximum-in-generated-array/
        if(n == 0 || n == 1){
            return n;
        }

        int [] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        int max = Integer.MIN_VALUE;

        for(int i = 2; i < n+1; i++){
            if(i % 2 == 0){
                arr[i] = arr[i/2];
            } else {
                arr[i] = arr[i/2] + arr[(i/2)+1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
