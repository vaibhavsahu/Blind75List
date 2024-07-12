import java.util.*;

public class RottenOranges {


/*
Given a grid of numbers where each cell can have one of three values:
  0: Represents an empty cell.
  1: Represents a fresh orange.
  2: Represents a rotten orange.
Every minute, any fresh orange that shares a side with a rotten orange also becomes rotten.
Your task is to return the minimum time after which all the oranges will rot
2,1,1           2,2,1       2,2,2           2,2,2
1,0,0    ->     2,0,0   ->  2,0,0       ->  2,0,0
1,1,0           1,1,0       2,1,0           2,2,0
*/

    //check presence of rotten oranges
    /*
    {
"grid": [
[1, 1, 1, 1],
[1, 1, 1, 1],
[1, 1, 1, 1],
[1, 1, 1, 1]
]
}

{
"grid": [
[2, 1, 1, 2],
[1, 1, 1, 1],
[1, 1, 1, 1],
[2, 1, 1, 2]
]
}

//1, 0, 1, 1, 2
    /*
[1, 1, 1, 1],
[1, 1, 1, 1],
[1, 1, 1, 1],
[1, 1, 1, 2]
--------------
[2, 1, 1, 2],
[1, 1, 1, 1],
[1, 1, 1, 1],
[2, 1, 1, 2]
     */


    static int [] x= {-1,0,0,1};
    static int [] y= {0, 1,-1,0};
    static Integer rotting_oranges(ArrayList<ArrayList<Integer>> grid) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int rows = grid.size();
        int cols = grid.get(0).size();

        if(rows == 1 && cols == 1){
            if(grid.get(rows-1).get(cols-1) == 0) return 0;
            if(grid.get(rows-1).get(cols-1) == 1) return -1;
            if(grid.get(rows-1).get(cols-1) == 2) return 0;
        }
        //get list of positions of rotten oranges
        List<Map.Entry<Integer, Integer>> rottenEntries = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> freshEntries = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid.get(i).get(j) == 2){
                    rottenEntries.add(new AbstractMap.SimpleEntry<>(i, j));
                }
                if(grid.get(i).get(j) == 1){
                    freshEntries.add(new AbstractMap.SimpleEntry<>(i, j));
                }
            }
        }

        if(freshEntries.isEmpty()) return 0;
        //if all ones, return -1
        if(rottenEntries.isEmpty()) return -1;
        //creating resultant grid
        for(var row: grid){
            var temp = new ArrayList<Integer>();
            for(int col : row){
                if(col == 1){
                    temp.add(2);
                } else{
                    temp.add(col);
                }
            }
            result.add(temp);
        }

        if(result.equals(grid)) return 0;


        return bfsCount(rottenEntries, grid, result, rows, cols);
    }


    static int bfsCount(List<Map.Entry<Integer, Integer>> rottenEntries,
                        ArrayList<ArrayList<Integer>> grid, ArrayList<ArrayList<Integer>> result,
                        int rows, int cols){

        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>(rottenEntries);

        if(grid.equals(result)) return 0;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Map.Entry<Integer, Integer> entry = queue.remove();
                for(int j = 0; j < x.length; j++){
                    if(isValidNeighbor(entry.getKey()+x[j], entry.getValue()+y[j], rows, cols, grid)){
                        grid.get(entry.getKey()+x[j]).set(entry.getValue()+y[j], 2);
                        queue.add(new AbstractMap.SimpleEntry<>(entry.getKey()+x[j], entry.getValue()+y[j]));
                    }
                }
            }
            count++;
        }

        return !grid.equals(result) ? -1 : count-1;
    }


    static boolean isValidNeighbor(int row, int col, int rows, int cols,
                                   ArrayList<ArrayList<Integer>> grid){
        if(row < 0 || row >= rows || col < 0 || col >= cols
                || grid.get(row).get(col) == 2 || grid.get(row).get(col) == 0) return false;

        return true;
    }


}
