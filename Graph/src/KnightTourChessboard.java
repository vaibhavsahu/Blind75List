import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
{
"rows": 5,
"cols": 5,
"start_row": 0,
"start_col": 0,
"end_row": 4,
"end_col": 1
}
* */
public class KnightTourChessboard {
    static int [] x = {-2,-2,-1,-1,1,1,2,2};
    static int [] y = {-1,1,-2,2,-2,2,-1,1};
    static Integer find_minimum_number_of_moves(Integer rows, Integer cols,
                                                Integer start_row, Integer start_col,
                                                Integer end_row, Integer end_col) {

        if(start_row == end_row && start_col == end_col) return 0;

        boolean [][] visitedStart = new boolean[rows][cols];
        boolean [][] visitedEnd = new boolean[rows][cols];

        Queue<Map.Entry<Integer, Integer>> queue1 = new LinkedList<>();
        queue1.add(new AbstractMap.SimpleEntry<>(start_row, start_col));
        visitedStart[start_row][start_col] = true;

        Queue<Map.Entry<Integer, Integer>> queue2 = new LinkedList<>();
        queue2.add(new AbstractMap.SimpleEntry<>(end_row, end_col));
        visitedEnd[end_row][end_col] = true;

        int [][] distanceStart = new int[rows][cols];
        int [][] distanceEnd = new int[rows][cols];


        while (!queue1.isEmpty() && !queue2.isEmpty()){
            Map.Entry<Integer, Integer> entry1 = queue1.remove();

            for(int i = 0; i < x.length; i++){
                if(isValidMove(rows, cols, entry1.getKey() +x[i], entry1.getValue()+y[i], visitedStart)){
                    int row = entry1.getKey() +x[i];
                    int col = entry1.getValue()+y[i];
                    visitedStart[row][col] = true;
                    distanceStart[row][col] = distanceStart[entry1.getKey()][entry1.getValue()]+1;
                    queue1.add(new AbstractMap.SimpleEntry<>(row, col));
                    if(visitedEnd[row][col]){
                        return distanceStart[row][col]+distanceEnd[row][col];
                    }
                }
            }
            Map.Entry<Integer, Integer> entry2 = queue2.remove();

            for(int j = 0; j < x.length; j++){
                if(isValidMove(rows, cols, entry2.getKey() +x[j], entry2.getValue()+y[j], visitedEnd)){
                    int row = entry2.getKey() +x[j];
                    int col = entry2.getValue()+y[j];
                    visitedEnd[row][col] = true;
                    distanceEnd[row][col] = distanceEnd[entry2.getKey()][entry2.getValue()]+1;
                    queue2.add(new AbstractMap.SimpleEntry<>(row, col));
                    if(visitedStart[row][col]){
                        return distanceStart[row][col]+distanceEnd[row][col];
                    }
                }
            }
        }
        return -1;
    }

    static boolean isValidMove(int rows, int cols, int i, int j, boolean [][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) return false;

        return true;
    }

}
