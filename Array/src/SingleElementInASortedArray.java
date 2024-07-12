public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if (arr.length == 1)
            return arr[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid - 1 >= 0 && mid+1 < arr.length
                    && arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];
            else if ((mid + 1 < arr.length
                    && mid % 2 == 0 && arr[mid] == arr[mid + 1])
                    || (mid - 1 >= 0 && mid % 2 != 0 &&
                    arr[mid] == arr[mid - 1]))
                start = mid + 1;
            else
                end = mid - 1;
        }

        return arr[start];
    }
}
