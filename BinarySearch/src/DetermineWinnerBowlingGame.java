//https://leetcode.com/problems/determine-the-winner-of-a-bowling-game

public class DetermineWinnerBowlingGame {
    public static int isWinner(int[] player1, int[] player2) {

        int sum1=player1[0];
        int sum2=player2[0];
        for(int i = 1; i < player1.length; i++){
            if(player1[i-1] == 10 ){
                sum1 += 2 * player1[i];
            }
            else if( i!=1 && player1[i-2] == 10 ){
                sum1 += 2 * player1[i];
            }
            else{
                sum1 += player1[i];
            }
        }

        for(int i = 1; i < player2.length; i++){
            if(player2[i-1] == 10 ){
                sum2 += 2*player2[i];
            }
            else if( i!=1 && player2[i-2] == 10 ){
                sum2 += 2 * player2[i];
            }
            else{
                sum2 += player2[i];
            }
        }

        return sum1 > sum2 ? 1 : sum1 < sum2 ? 2 : 0;

    }

    public static void main(String[] args) {
       int [] player1 = {7,8,8,5,2};
        int [] player2 = {10,1,4,2,6};
        System.out.println(isWinner(player1, player2));
    }
}
