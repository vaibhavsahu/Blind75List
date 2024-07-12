import java.util.ArrayList;
import java.util.List;

public class SplitStringsbySeparator {

     public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        //https://leetcode.com/problems/split-strings-by-separator/
        //2788. Split Strings by Separator
       List<String> list = new ArrayList<>();
        for(String word : words){
            String [] strs = word.split("["+separator+"]");
            for(String str : strs){
                if(!str.isEmpty() && !str.isBlank() && !list.contains(str))  list.add(str);
            }
        }
        return list.stream().distinct().toList();
    }

    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(List.of("one.two.three","four.five","six"), '.'));
    }
}
