public class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs.length == 1) return Math.min(Math.min(costs[0][0],
                costs[0][1]), costs[0][2]);

        int [] red = new int[costs.length];
        int [] green = new int[costs.length];
        int [] blue = new int[costs.length];
        int [] result = new int[costs.length];

        red[0] = costs[0][0];
        green[0] = costs[0][1];
        blue[0] = costs[0][2];

        for(int i = 1; i < costs.length; i++){
            red[i] = Math.min(green[i-1], blue[i-1])+costs[i][0];
            green[i] = Math.min(blue[i-1], red[i-1])+costs[i][1];
            blue[i] = Math.min(green[i-1], red[i-1])+costs[i][2];
            result[i] = Math.min(Math.min(blue[i], green[i]), red[i]);
        }
        return result[costs.length-1];
    }
}
