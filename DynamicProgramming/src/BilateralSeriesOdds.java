public class BilateralSeriesOdds {
    public static double WS(int matches, double p) {
        var prob = new double[matches][matches];
        prob[0][0] = 1; // Fill in probabilities for team A sweeping.
        for (var i = 1; i < matches; i++) prob[i][0] = p * prob[i - 1][0];
        // Probabilities for team B sweeping
        for (var i = 1; i < matches; i++) prob[0][i] = (1 - p) * prob[0][i - 1];
        // Here's where we fill in the table, using the recursive // formula.
        for (var i = 1; i < matches; i++)
            for (var j = 1; j < i; j++)
                prob[i][i] = p * prob[i - 1][j] + (1 - p) * prob[i][j - 1];
        // Here's our answer.
        return prob[matches-1][matches-1];
    }

    public static void main(String[] args) {
        System.out.println(WS(7, 0.4));
    }
}
