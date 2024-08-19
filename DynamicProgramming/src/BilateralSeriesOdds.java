
public class BilateralSeriesOdds {
    public static double WS(int matches, double p) {
        var prob = new double[matches+1][matches+1];
        prob[0][0] = p; // Fill in probabilities for team A sweeping.
        for(var t = 1; t <= matches; t++){
            prob[0][t] = p;
            prob[t][0] = 1-p;
            for(var k = 1; k < t; k++){
                prob[t][t-k] = prob[k-1][t-k] * p + prob[k][t-k-1] * (1-p);
            }
        }

        return prob[4][3];
    }

    public static void main(String[] args) {
        System.out.println(WS(7, 0.4));
    }
}
