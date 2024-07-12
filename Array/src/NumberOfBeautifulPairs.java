public class NumberOfBeautifulPairs {
    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
//https://leetcode.com/problems/number-of-beautiful-pairs/
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int first = ("" + nums[i]).charAt(0) - '0';
                int last = nums[j] % 10;
                if(gcd(first, last) == 1) count++;
            }
        }
        return count;
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(countBeautifulPairs(new int[]{11,21,12}));
    }
}
