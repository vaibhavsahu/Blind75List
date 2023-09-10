import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();

        List<Boolean> answer = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        return answer;
    }
}
