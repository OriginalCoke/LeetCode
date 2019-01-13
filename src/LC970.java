import java.util.ArrayList;
import java.util.List;

public class LC970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        int m = 0, n = 0;
        while (x != 1 && Math.pow(x, m) <= bound) m++;
        while (y != 1 && Math.pow(y, n) <= bound) n++;
        if (x == 1) m = 1;
        if (y == 1) n = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = (int) Math.round(Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound && !res.contains(sum)) res.add(sum);
            }
        }
        return res;
    }
}
