import java.util.Arrays;

public class LC1005 {
    //Maximize Sum Of Array After K Negations
    //排序后贪心
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int index = -1, n = A.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) {
                index = i;
                break;
            }
        }
        if (index >= K || index < 0) {
            for (int i = 0; i < n; i++) {
                if (i < K) sum -= A[i];
                else sum += A[i];
            }
        } else {
            int rem = K - index;
            if (rem % 2 == 0) {
                for (int a : A) sum += Math.abs(a);
            } else {
                int min = A[index];
                if (index != 0) min = Math.min(A[index], -A[index - 1]);
                for (int a : A) sum += Math.abs(a);
                sum -= 2 * min;
            }
        }
        return sum;
    }
}
