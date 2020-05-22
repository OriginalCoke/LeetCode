import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LC1394 {
    //1394. Find Lucky Integer in an Array
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        int res = -1;
        for (int k : map.keySet()) {
            if (k == map.get(k)) res = Math.max(res, k);
        }
        return res;
    }
}
