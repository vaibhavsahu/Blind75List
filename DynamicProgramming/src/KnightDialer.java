import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KnightDialer {
    public static int knightDialer(int n) {

        Map<Integer, List<Integer>> moveMap = Map.of(0, List.of(4, 6),
                1, List.of(6, 8),
                2, List.of(7,9),
                3, List.of(4,8),
                4, List.of(0,3,9),
                5, List.of(),
                6, List.of(0,1,7),
                7, List.of(2,6),
                8, List.of(1,3),
                9, List.of(2,4));

        int [][] result = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            result[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int num : moveMap.get(j)){
                    result[i][j] = (result[i][j]  + result[i-1][num]) %  1_000_000_007;
                }
            }
        }
//       for (int [] rr : result){
//           System.out.println(Arrays.toString(rr));
//       }
        int res = 0;
        for(int i = 0; i < result[n].length; i++){
            res = (res+result[n][i]) % 1_000_000_007;
        }

        return res ;
    }
}
