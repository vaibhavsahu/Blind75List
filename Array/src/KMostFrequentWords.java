import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class KMostFrequentWords {

     List<String> k_most_frequent(ArrayList<String> words, Integer k ) {

        List<String> list = new ArrayList<>();
         Map<String, Integer> map = new HashMap<>();

         for(String word: words){
             map.put(word, map.getOrDefault(word, 0)+1);
         }

         Comparator<Map.Entry<String, Integer>> comparatorByValue = Map.Entry.comparingByValue();
         Comparator<Map.Entry<String, Integer>> comparatorByKey = Map.Entry.comparingByKey();
         PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(comparatorByValue.reversed()
                 .thenComparing(comparatorByKey));
         queue.addAll(map.entrySet());

         int count = 0;

        while(count++ < k){
            list.add(queue.remove().getKey());
        }

        return list;
    }

}
