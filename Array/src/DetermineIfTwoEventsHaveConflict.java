import java.time.LocalTime;

public class DetermineIfTwoEventsHaveConflict {
    //https://leetcode.com/problems/determine-if-two-events-have-conflict/
    public static boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        String end1 = event1[1];
        String start2 = event2[0];
        String end2 = event2[1];

        if(LocalTime.parse(start2).equals(LocalTime.parse(end1))
                || LocalTime.parse(start1).equals(LocalTime.parse(end2))){
            return true;
        }

        return LocalTime.parse(start2).isBefore(LocalTime.parse(end1)) &&
                LocalTime.parse(start1).isBefore(LocalTime.parse(end2));
    }

    public static void main(String[] args) {
       String [] event1 =
               {"14:13","22:08"};
      String []  event2 =
              {"02:40","08:08"};

        System.out.println(haveConflict(event1, event2));
    }
}
