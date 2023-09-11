import java.util.List;
//https://leetcode.com/problems/count-items-matching-a-rule/
public class CountItemsMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> item: items){
            int idx = switch (ruleKey) {
                case "type" -> 0;
                case "color" -> 1;
                case "name" -> 2;
                default -> 0;
            };
            if(item.get(idx).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
