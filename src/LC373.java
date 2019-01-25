import java.util.*;

public class LC373 {
    //Find K Pairs with Smallest Sums
    //Google
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] + o1[1] == o2[0] + o2[1]) return o1[0] - o2[0];
                else return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] temp = {nums1[i], nums2[j]};
                pq.offer(temp);
                //if (pq.size() > k) pq.poll();
            }
        }
        List<int[]> res = new ArrayList<>();
        if (pq.isEmpty()) return res;
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}
