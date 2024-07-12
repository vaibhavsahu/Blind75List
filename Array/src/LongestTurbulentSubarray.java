public class LongestTurbulentSubarray {

    public static int maxTurbulenceSize(int[] arr) {
        if(arr.length<2) return arr.length ;
        int left = 0 ;
        int right = 0 ;

        int max=1 ;
        while( left+1 < arr.length){
            if(arr[left] == arr[left+1]) {
                left++;
                continue ;
            }
            right = left+1;
            while(right+1 < arr.length &&
                    (arr[right]>arr[right+1] && arr[right]>arr[right-1]
                    || arr[right]<arr[right+1] && arr[right]<arr[right-1])) {
                right++;
            }
            max=Math.max(max ,right-left+1);
            left=right ;
        }
        return max ;
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int []{9,4,2,10,7,8,8,1,9}));
    }
}
