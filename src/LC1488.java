import java.util.*;

public class LC1488 {
    //1488. Avoid Flood in The City
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (rains[i] == 0) {
                zeros.add(i);
                res[i] = 1;
            } else {
                if (map.containsKey(lake)) {
                    //get the previous lake date
                    Integer next = zeros.ceiling(map.get(lake));
                    if (next == null) return new int[0];
                    res[next] = lake;
                    zeros.remove(next);
                }
                res[i] = -1;
                //update the lake with the current day
                map.put(lake, i);
            }
        }
        return res;
    }
}
