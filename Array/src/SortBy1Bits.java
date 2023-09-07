import java.util.*;
import java.util.stream.Collectors;

class Pair<U, V>{
    U first;
    V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst(){
        return this.first;
    }
}

class SortBy1Bits {
    public static int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        Arrays.sort(arr);

        for(int num : arr){
            int count1s = countOnes(Integer.toBinaryString(num));
            map.computeIfAbsent(count1s, k -> new ArrayList<>()).add(num);
        }

        int [] res = new int [arr.length];
        int idx = 0;

        List<Integer> list = map.values().stream().flatMap(List::stream).toList();
        // Collections.reverse(list);

        for(int num: list){
            res[idx] = num;
            idx++;
        }

        return res;

    }

    public static int countOnes(String binaryString){
        int count = 0;

        for(char ch : binaryString.toCharArray()){
            if(ch == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sortByBits(new int []{1024,512,256,128,64,32,16,8,4,2,1}));
    }
}
