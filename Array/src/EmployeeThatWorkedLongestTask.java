public class EmployeeThatWorkedLongestTask {
//https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/description
    public static int hardestWorker(int n, int[][] logs) {
        int maxScore = logs[0][1];
        int maxElement = logs[0][0];
        int[] prev = logs[0];
        for (int i = 1; i < logs.length; i++) {
            int[] curr = logs[i];
            if (curr[1] - prev[1] == maxScore)
                maxElement = Math.min(maxElement, curr[0]);
            else if (curr[1] - prev[1] > maxScore) {
                maxScore = Math.max(maxScore, curr[1] - prev[1]);
                maxElement = curr[0];
            }
            prev = curr;
        }
        return maxElement;
    }

    public static void main(String[] args) {

        int [][] arr = {{0,10},{1,20}};
        System.out.println(hardestWorker(10, arr));
    }
}
