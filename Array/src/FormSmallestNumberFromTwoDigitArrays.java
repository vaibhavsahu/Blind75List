import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FormSmallestNumberFromTwoDigitArrays {
    public int minNumber(int[] nums1, int[] nums2) {
        //https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
        //2605. Form Smallest Number From Two Digit Arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        if(nums1.length > nums2.length){
            for(int num: nums1){
                set1.add(num);
            }
        } else {
            for(int num: nums2){
                set2.add(num);
            }
        }


        boolean cont = false;
        int number = 0;
        if(nums1.length > nums2.length){
            for(int num: nums2){
                if(set1.contains(num)){
                    number =  num;
                    cont = true;
                    break;
                }
            } } else {
            for(int num: nums1){
                if(set2.contains(num)){
                    number =  num;
                    cont = true;
                    break;
                }
            }
        }


        if(!cont){
            int digit1 = nums1[0];
            int digit2 = nums2[0];

            return digit1 > digit2 ? (digit2*10)+digit1 : (digit1*10)+digit2;
        }

        return number;

    }
}
