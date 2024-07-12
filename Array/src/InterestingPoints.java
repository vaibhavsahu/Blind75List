import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class InterestingPoints {
    static int interestingPoint(String S, String T){
        int count = 0;
        LocalTime  start = LocalTime.parse(S, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime  end = LocalTime.parse(T, DateTimeFormatter.ofPattern("HH:mm:ss"));
        Set<Integer> set = new HashSet<>();
        end = end.plusSeconds(1L);
        if(start.isAfter(end)){
            return 0;
        }
        while(!start.equals(end)){
            String [] str = start.format(DateTimeFormatter.ofPattern("HH:mm:ss")).split(":");
            for(String time : str){
                int num = Integer.parseInt(time);
                int first = num /10;
                int second = num % 10;
                set.add(first);
                set.add(second);
            }
            if(set.size() <= 2){
                count++;
            }
            set.clear();
            start = start.plusSeconds(1L);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(interestingPoint("22:00:00", "22:22:01"));
    }
}
