import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public  class Triple {
        public final int x;
        public final Pair<Integer, Integer> pair;

        public Triple(int x, Pair<Integer, Integer> pair) {
            this.x = x;
            this.pair = pair;
        }

        public static List<Triple> toList(int[][] ds) {
            List<Triple> l = new ArrayList<>(ds.length);
            for (int[] d : ds)
                l.add(new Triple(d[0], new Pair<>(d[1], d[2])));
            return l;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return x == triple.x && Objects.equals(pair, triple.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, pair);
    }
}

