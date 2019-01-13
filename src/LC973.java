import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {
    //K Closest Points to Origin
    //Solution 1: max PriorityQueue
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();//每次把最大的poll出去,留下K个较小值
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    //Solution 2 : Array sort
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        //return Arrays.copyOfRange(points, 0, K);
        return Arrays.copyOf(points, K);
    }

}
