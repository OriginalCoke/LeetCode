public class LC1482 {
    //1482. Minimum Number of Days to Make m Bouquets
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int v : bloomDay) {
            lo = Math.min(lo, v);
            hi = Math.max(hi, v);
        }
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int adjacent = 0, bou = 0;
            for (int b : bloomDay) {
                if (b > mid) {
                    adjacent = 0;
                } else {
                    adjacent++;
                    if (adjacent == k) {
                        bou++;
                        adjacent = 0;
                    }
                }
            }
            if (bou >= m) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }
}
