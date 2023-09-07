public class MedianRowWiseSortedMatrix {
    public static int matrixMedian(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int low = 1;
        int high = 1000000;

        high = Math.max(low, high);

        while(low <= high){
            int mid = (low+high)/2;

            int cnt = 0;
            for(int i = 0; i < m; i++){
                cnt += countSmallerThanEqualToMid(grid[i], mid);
            }

            if(cnt <= (n*m)/2)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

    static int countSmallerThanEqualToMid(int [] mat, int mid){
        int l = 0;
        int h = mat.length-1;

        while( l <= h ){
            int m = (l+h)/2;

            if(mat[m] <= mid){
                l = m+1;
            } else {
                h = m -1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(matrixMedian(new int [][]{{1,1,2}, {2,3,3}, {1,3,4}}));
    }
}
