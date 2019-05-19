import java.util.*;

public class LC1046 {
    //Last Stone Weight
    //需要每次取出最大的 2 个, 相等都舍去, 不相等则取差值重新放入队列进行排序
    public int lastStoneWeight(int[] stones) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int stone : stones) pq.offer(stone);
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            if (a == b) continue;
            else pq.offer(a - b);
        }
        if (pq.size() < 1) return 0;
        else return pq.peek();
    }
    //TC: nlog(n)   SC: n
}
