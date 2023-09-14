public class PrimeInDiagonal {
    //https://leetcode.com/problems/prime-in-diagonal

    public int diagonalPrime(int[][] nums) {
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            if(prime(nums[i][i]))
                result = Math.max(result, nums[i][i]);
        }

        for(int j = nums.length-1, i = 0; i < nums.length && j>=0;j--, i++){
            if(prime(nums[i][j]))
                result = Math.max(result, nums[i][j]);
        }

        return result;
    }

    public static boolean prime(int n){
        if (n<=1){
            return false;
        }
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
