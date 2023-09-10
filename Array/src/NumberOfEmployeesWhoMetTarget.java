//2798. Number of Employees Who Met the Target
//https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count= 0;
        for(int num : hours){
            if(num >= target)
                count++;
        }
        return count;
    }
}
