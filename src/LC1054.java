import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1054 {
    //Distant Barcodes
    //重新排列数组使得相邻的不相等, 将 (num, freq) 放进优先队列, 初始化 poll 第一个放入
    //每次取 2 个头部键值对, 放入保持不同, 每次放入 res 后对频数减一, 重新放入队列
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int b : barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int m : map.keySet()) {
            pq.add(new int[]{m, map.get(m)});
        }
        int[] res = new int[n];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (index == 0 || first[0] != res[index - 1]) {
                res[index] = first[0];
                index++;
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                res[index] = second[0];
                index++;
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return res;
    }
}
