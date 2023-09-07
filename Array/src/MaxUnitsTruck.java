import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MaxUnitsTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[0]));

        int capacitySoFar = 0;
        int totalUnits = 0;
        int index = 0;
        String s = "";

        while(capacitySoFar +  boxTypes[index][0] <= truckSize){
            if(capacitySoFar +  boxTypes[index][0] <= truckSize){
                capacitySoFar += boxTypes[index][0];
                totalUnits += (boxTypes[index][0] * boxTypes[index][1]);
                index++;
            } else {
                break;
            }
        }

        int diff = truckSize - capacitySoFar;
        totalUnits += (diff * boxTypes[index][1]);

        return totalUnits;
    }

    public static void main(String[] args) {
        int [][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(boxTypes, 10));
    }
}
