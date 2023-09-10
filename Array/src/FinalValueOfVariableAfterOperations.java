public class FinalValueOfVariableAfterOperations {
   //https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (String operation : operations) {
            switch (operation) {
                case "--X", "X--" -> --x;
                case "++X", "X++" -> ++x;
                default -> {
                }
            }
        }
        return x;
    }
}
