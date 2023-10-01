public class CheckIfItIsStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        //https://leetcode.com/problems/check-if-it-is-a-straight-line/

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 1; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
                return false;
        }
        return true;
    }
}
