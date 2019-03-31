import java.util.*;

public class LC1017 {
    //Convert to Base -2
    //
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int r = N % 2;
            sb.append(r);
            if (sb.length() % 2 == 0) {
                N = (N + r) / 2;
            } else {
                N = (N - r) / 2;
            }
        }
        return sb.reverse().toString();
    }
}
