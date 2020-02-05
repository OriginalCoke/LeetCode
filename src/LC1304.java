public class LC1304 {
    //Find N Unique Integers Sum up to Zero
    //对称
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int first = -n / 2;
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                res[i] = first + i;
            }
        } else {
            int last = -first * 2 - 1;
            for (int i = 0; i < n; i++) {
                if (i != n - 1) {
                    res[i] = first + i;
                } else res[i] = last;
            }
        }
        return res;
    }
}
