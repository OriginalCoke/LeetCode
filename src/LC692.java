import java.util.*;

public class LC692 {
    //Top K Frequent Words
    //Amazon
    //用 map 计数,把entry放进一个优先队列,我下面用的最大堆,堆顶的是最大的
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) ->
                        (a.getValue() == b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int i = 0;
        while (i < k && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
            i++;
        }
        return res;
    }
}
