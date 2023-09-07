import org.w3c.dom.ls.LSOutput;

public class NumSubarraysDivByK {
    public static int numSubarraysDivByK(int[] nums, int k) {
        int prefixMod = 0;
        int [] modGroups = new int[k];
        int count = 0;
        modGroups[0] = 1;

        for(int num: nums){
            if(num < 0){
                prefixMod =  (prefixMod + k - Math.abs(num) % k);
            } else {
                prefixMod += num % k;
            }
            count += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysDivByK(new int [] {4,5,0,-2,-3,1}, 5));
    }
}
