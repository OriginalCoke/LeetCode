import java.util.*;

public class LC1481 {
    //1481. Least Number of Unique Integers after K Removals
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int n = list.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int v = list.get(i);
            if (k < v) {
                res = n - i;
                break;
            } else k -= v;
        }
        return res;
    }
}
