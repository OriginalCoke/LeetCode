public class LC1007 {
    //Minimum Domino Rotations For Equal Row
    //判断最小的不同处
    public int minDominoRotations(int[] A, int[] B) {
        int res = A.length + 1;
        for (int v = 1; v <= 6; v++) {
            int countA = 0, countB = 0;
            boolean f = true;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != v && B[i] != v) {
                    f = false;
                    break;
                } else if (A[i] == v && B[i] == v) continue;
                else if (A[i] == v && B[i] != v) countA++;
                else if (A[i] != v && B[i] == v) countB++;
            }
            if (f) {
                int temp = Math.min(countA, countB);
                res = Math.min(temp, res);
            }
        }
        if (res > A.length) return -1;
        return res;
    }
}
