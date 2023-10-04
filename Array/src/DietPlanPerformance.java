public class DietPlanPerformance {
    //https://leetcode.com/problems/diet-plan-performance/description/
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int points = 0;
        for(int i=0; i < k; i++)
            sum += calories[i];
        if(sum < lower) points--;
        if(sum > upper) points++;
        for(int i = k; i < calories.length; i++){
            sum += calories[i] - calories[i-k];
            if(sum < lower) points--;
            if(sum > upper) points++;

        }
        return points;
    }

    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[]{6,5,0,0}, 2, 1, 5));
    }
}
