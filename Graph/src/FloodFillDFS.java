import java.util.ArrayList;

public class FloodFillDFS {

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column,
                                                    Integer new_color, ArrayList<ArrayList<Integer>> image) {
       int rows = image.size();
       int cols = image.get(0).size();


        boolean [][] visited = new boolean[rows][cols];
        int oldColr = image.get(pixel_row).get(pixel_column);
        dfs(pixel_row, pixel_column, new_color, oldColr, image, visited, rows, cols);

        return image;
    }

    private static void dfs(Integer pixelRow, Integer pixelColumn,
                            Integer newColor, int oldColr,
                            ArrayList<ArrayList<Integer>> image,
                            boolean[][] visited, int rows, int cols) {

        if(pixelRow < 0 || pixelRow >= rows ||
                pixelColumn  < 0 || pixelColumn >= cols
                || visited[pixelRow][pixelColumn] || image.get(pixelRow).get(pixelColumn) != oldColr) return;

        visited[pixelRow][pixelColumn] = true;
        image.get(pixelRow).set(pixelColumn, newColor);

        dfs(pixelRow+1, pixelColumn, newColor, oldColr, image, visited, rows, cols);
        dfs(pixelRow-1, pixelColumn, newColor, oldColr, image, visited, rows, cols);
        dfs(pixelRow, pixelColumn+1, newColor , oldColr, image, visited, rows, cols);
        dfs(pixelRow, pixelColumn-1, newColor, oldColr, image, visited, rows, cols);
    }



}
