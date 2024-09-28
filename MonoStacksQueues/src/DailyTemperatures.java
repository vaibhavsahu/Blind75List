import java.util.*;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temps) {
        int [] ans = new int[temps.length];

        for(int i = 0; i < temps.length; i++){
            for (int j = i+1; j < temps.length; j++) {
                if(temps[j] > temps[i]){
                    ans[i] = j-i;
                    break;
                }
            }

        }
        return ans;
    }

    public static int [] dailyTemperatures2(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temps[currDay];
            while (!stack.isEmpty() && temps[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
