import java.math.BigInteger;

public class PowerBOfA {
    static Integer calculate_power(Long a, Long b) {
        return calculate_powerHelper(a, b, 1000000007L);
    }

    static Integer calculate_powerHelper(Long a, Long b, Long c){
        if(b == 0) return 1;
        else if(b % 2 == 0){
            int prod = calculate_powerHelper(a, b/2, c);
            return Math.toIntExact(((long) prod * prod) % c);
        } else {
            return Math.toIntExact((a % c * calculate_powerHelper(a, b - 1, c)) % c);
        }
    }
}
