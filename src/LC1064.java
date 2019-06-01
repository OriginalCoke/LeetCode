public class LC1064 {
    //Fixed Point
    //升序数列, 二分
    public int fixedPoint(int[] A) {
        int n = A.length, lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2, v = A[mid];
            if (v == mid) return v;
            else if (v > mid) hi--;
            else lo++;
        }
        return -1;
    }
}
