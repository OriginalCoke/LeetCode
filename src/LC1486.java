public class LC1486 {
    //1486. XOR Operation in an Array
    public int xorOperation(int n, int start) {
        int[] A = new int[n];
        int res = start;
        for (int i = 1; i < n; i++) {
            A[i] = start + 2 * i;
            res = res ^ A[i];
        }
        return res;
    }
}
