import java.util.*;
import java.util.stream.Collectors;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        avails.forEach(e -> pq.addAll(e));

        System.out.println(pq);

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(employeeFreeTime(List.of(
                List.of(new Interval(7,24), new Interval(29,33),
                        new Interval(45, 57), new Interval(66, 69), new Interval(94, 99)),
                List.of(new Interval(6,24), new Interval(43,49),
                        new Interval(56, 59), new Interval(61, 75), new Interval(80, 81)),
                List.of(new Interval(5,16), new Interval(18,26),
                        new Interval(33, 36), new Interval(39, 57), new Interval(65, 74)),
                List.of(new Interval(9,16), new Interval(27,35),
                        new Interval(40, 55), new Interval(68, 71), new Interval(78, 81)),
                List.of(new Interval(0,25), new Interval(29,31),
                        new Interval(40, 47), new Interval(57, 87), new Interval(91, 94)))));
    }
}
