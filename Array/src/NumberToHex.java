import java.util.AbstractMap;
import java.util.*;
import java.util.stream.Stream;

public class NumberToHex {
    public static String toHex(int num) {
        Map<Integer, Character> myMap = Stream.of(
                        new AbstractMap.SimpleEntry<>(0, '0'),
                        new AbstractMap.SimpleEntry<>(1, '1'),
                        new AbstractMap.SimpleEntry<>(2, '2'),
                        new AbstractMap.SimpleEntry<>(3, '3'),
                        new AbstractMap.SimpleEntry<>(4, '4'),
                        new AbstractMap.SimpleEntry<>(5, '5'),
                        new AbstractMap.SimpleEntry<>(6, '6'),
                        new AbstractMap.SimpleEntry<>(7, '7'),
                        new AbstractMap.SimpleEntry<>(8, '8'),
                        new AbstractMap.SimpleEntry<>(9, '9'),
                        new AbstractMap.SimpleEntry<>(10, 'a'),
                        new AbstractMap.SimpleEntry<>(11, 'b'),
                        new AbstractMap.SimpleEntry<>(12, 'c'),
                        new AbstractMap.SimpleEntry<>(13, 'd'),
                        new AbstractMap.SimpleEntry<>(14, 'e'),
                        new AbstractMap.SimpleEntry<>(15, 'f'))
                        .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);
                StringBuilder sb = new StringBuilder();

        while (num != 0) {
            num = num & 15;
            sb.append(myMap.get(num));
            num = num >> 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(23));
    }
}
