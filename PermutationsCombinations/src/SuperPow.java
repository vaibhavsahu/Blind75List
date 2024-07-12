import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SuperPow {
    public int superPow(int a, int[] b) {
        String arr = IntStream.of(b)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(""));

        return superPowHelper(a, new BigInteger(arr), 1337) ;

    }

    public int superPowHelper(int a, BigInteger number, int c){
        if(number.equals(BigInteger.ZERO)){
            return 1;
        } else if(number.remainder(BigInteger.TWO).equals(BigInteger.ZERO)){
            int prod = superPowHelper(a, number.divide(BigInteger.valueOf(2)), c);
            return  (prod * prod) % c;
        } else {
            return (a % c * superPowHelper(a, number.subtract(BigInteger.ONE), c) % c) ;
        }
    }
}
