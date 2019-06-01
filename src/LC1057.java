import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1057 {
    //Campus Bikes
    //优先队列
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[] res = new int[n];
        boolean[] vw = new boolean[n], vb = new boolean[m];
        int[][] A = new int[n * m][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[index][0] = i;
                A[index][1] = j;
                index++;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int disA = Math.abs(workers[a[0]][0] - bikes[a[1]][0]) + Math.abs(workers[a[0]][1] - bikes[a[1]][1]);
                int disB = Math.abs(workers[b[0]][0] - bikes[b[1]][0]) + Math.abs(workers[b[0]][1] - bikes[b[1]][1]);
                if (disA == disB && a[0] == b[0]) return a[1] - b[1];
                else if (disA == disB) return a[0] - b[0];
                else return disA - disB;
            }
        });
        for (int i = 0; i < n * m; i++) pq.offer(A[i]);
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int w = temp[0], b = temp[1];
            if (vw[w] || vb[b]) continue;
            res[w] = b;
            vw[w] = true;
            vb[b] = true;
        }
        return res;
    }
}
