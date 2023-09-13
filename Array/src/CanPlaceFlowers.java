public class CanPlaceFlowers {
//https://leetcode.com/problems/can-place-flowers
    public static boolean canPlaceFlowers(int[] arr, int n) {
        int count = 0;
        int right = 1;

        if (arr.length == 1 && n == 1 && arr[0] == 0) {
            return true;
        }

        if (arr.length >= 2 && n >= 1 && arr[0] == 0 && arr[1] == 0) {
            arr[0] = 1;
            count++;
        }

        while (right < arr.length - 1) {
            if (arr[right] == 0 && arr[right - 1] == 1 && arr[right + 1] == 0 && right + 1 == arr.length - 1) {
                arr[right + 1] = 1;
                count++;
                right++;
                continue;
            } else if (arr[right] == 0 && arr[right - 1] == 0 && arr[right + 1] == 1 ||
                    arr[right] == 0 && arr[right - 1] == 1 && arr[right + 1] == 0
                    || arr[right] != arr[right - 1] && arr[right] != arr[right + 1]) {
                right++;
                continue;
            }
            while (arr[right] == 0 && arr[right] == arr[right - 1] && arr[right] == arr[right + 1]) {
                arr[right] = 1;
                count++;
                right++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0}, 2));
    }
}
