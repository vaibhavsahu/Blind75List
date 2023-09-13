import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards
public class XKindInDeckOfCards {
    public static boolean hasGroupsSizeX(int[] deck) {

        if(deck.length == 1){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: deck){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int res = 0;

        for (int i : map.values()) res = gcd(i, res);
        return res > 1;
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int []{1,1,2,2,2,2}));
    }


}
