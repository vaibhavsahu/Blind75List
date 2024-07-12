public class MissingElementInSortedArray {
    public int missingElement(int[] arr, int k) {

        int missingLeft = 0;

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            missingLeft = arr[mid] - (arr[0]+mid);

            if(missingLeft < k) start = mid+1;
            else end = mid-1;
        }
        missingLeft = arr[end] -(arr[0]+end);
        return arr[end]+k-missingLeft;
    }
}
