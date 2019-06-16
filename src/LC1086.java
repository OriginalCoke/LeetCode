import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1086 {
    //High Five
    //PriorityQueue
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0], score = item[1];
            if (!map.containsKey(id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                map.put(id, pq);
                pq.offer(score);
            } else {
                PriorityQueue<Integer> pq = map.get(id);
                pq.offer(score);
                if (pq.size() > 5) pq.poll();
            }
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int k : map.keySet()) {
            res[i][0] = k;
            PriorityQueue<Integer> pq = map.get(k);
            int sum = 0, n = pq.size();
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            res[i][1] = sum / n;
            i++;
        }
        return res;
    }
}
