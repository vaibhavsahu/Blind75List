import java.util.HashMap;
import java.util.Map;

public class CoupleHoldingHands {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> seatIndexMap = new HashMap<>();
        int numswaps = 0;

        for (int i = 0; i < 2*row.length; i++) {
            seatIndexMap.put(row[i], i);
        }

        for(int i = 0; i < row.length-1; i++){
            int coupleLeft = row[2*i];
            int coupleRight = row[2*i+1];
            int coupleLeftExpected = -1;
            int coupleRightExpected = -1;

            if(coupleLeft % 2 == 0)
                coupleRightExpected = coupleLeft+1;
            else
                coupleRightExpected = coupleLeft-1;

            if (row[2*i+1] != coupleRightExpected){
                if(coupleRight % 2 == 0){
                    coupleLeftExpected = coupleRight+1;
                } else{
                    coupleLeftExpected = coupleRight-1;
                }
                int coupleRightPartnerIndex = seatIndexMap.get(coupleLeftExpected);
                int strangerIndex = -1;
                if(coupleRightPartnerIndex % 2 == 0){
                    strangerIndex = coupleRightPartnerIndex+1;
                } else {
                    strangerIndex = coupleRightPartnerIndex-1;
                }
                //swap
                int temp = row[2*i+1] ;
                row[2*i+1]  = row[strangerIndex];
                row[strangerIndex] = temp;
                numswaps++;
                seatIndexMap.put(row[2*i+1], 2*i+1);
                seatIndexMap.put(row[strangerIndex], strangerIndex);
                row[2*i+1]  = row[coupleRight];
            }
        }
        return numswaps;
    }
}
