import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1133 {
    //Largest Unique Number
    //数组没排序, 找最大的非重复数
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int k : map.keySet()) pq.offer(k);
        while (!pq.isEmpty()) {
            int top = pq.poll();
            if (map.get(top) == 1) return top;
        }
        return -1;
    }
}
