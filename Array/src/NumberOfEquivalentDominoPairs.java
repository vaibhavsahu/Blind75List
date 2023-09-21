import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/number-of-equivalent-domino-pairs/
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int  count=0;
        Map<String,Integer> map=new HashMap<>();
        int i=0;
        int n=dominoes.length;
        while(i<n){
            String temp="";
            if(dominoes[i][0]>dominoes[i][1]){
                temp+=dominoes[i][1];
                temp+=dominoes[i][0];
            }else{
                temp+=dominoes[i][0];
                temp+=dominoes[i][1];
            }
            if(map.containsKey(temp))count+=map.get(temp);
            map.put(temp,map.getOrDefault(temp,0)+1);
            i++;
        }
        return count;
    }
}
