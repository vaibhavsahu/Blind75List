/*
Given an integer array nums, return an array answer such that
answer[i] is equal to the product of all the elements of nums except nums[I].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Input: nums = [1,2,3,4] Output: [24,12,8,6]
 */
public class ProductArraySelf {

    public int [] productArrayExceptSelf(int [] nums){
        int [] leftProduct = new int[nums.length];
        int [] rightProduct = new int[nums.length];
        int [] result = new int[nums.length];

        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0; i < nums.length; i++) {
            if(i-1 < 0){
                leftProduct[i] = leftProd;
            } else {
                leftProd *= leftProd*nums[i-1];
                leftProduct[i] = leftProd;
            }
        }
        for (int i = nums.length-1; i >=0; i--) {
            if(i+1 > nums.length-1){
                rightProduct[i] = rightProd;
            } else {
                rightProd *= rightProd*nums[i+1];
                rightProduct[i] = rightProd;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i]*rightProduct[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
