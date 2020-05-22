import java.util.HashMap;
import java.util.Map;

public class LC1426 {
    //1426. Counting Elements
    public int countElements(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        for (int k : map.keySet()) {
            if (map.containsKey(k + 1)) res += map.get(k);
        }
        return res;
    }
}
