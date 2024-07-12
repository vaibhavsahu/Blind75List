public class FixedPoint {
    public int fixedPoint(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] < mid) start = mid+1;
            else end = mid-1;
        }

        return start < arr.length && arr[start] == start ? start : -1;
    }
}
