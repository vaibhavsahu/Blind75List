import java.util.ArrayList;
import java.util.List;

public class CheckNumbersAreAscendingInASentence {
    //https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
    public boolean areNumbersAscending(String s) {
        String [] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();

        for(String str: arr){
            if(isNumeric(str)){list.add(Integer.valueOf(str));}
        }

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public boolean isNumeric(String str){
        return str.chars().allMatch( Character::isDigit );
    }
}
