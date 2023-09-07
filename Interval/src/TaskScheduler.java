import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskScheduler {


    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> charFreqMap = new HashMap<>();
        int maxFrequency = Integer.MIN_VALUE;

        int mostFrequentTasks = 0;
        for(char c: tasks) {
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, charFreqMap.getOrDefault(c, 0));
        }

        for(Map.Entry<Character, Integer> entry: charFreqMap.entrySet()){
            if(entry.getValue() == maxFrequency){
                mostFrequentTasks++;
            }
        }

        return Math.max(tasks.length, (maxFrequency-1)* (n+1)+mostFrequentTasks );
    }
}
