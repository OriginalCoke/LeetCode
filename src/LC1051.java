import java.util.Arrays;

public class LC1051 {
    //Height Checker
    //要求不变动绝对位置, sort 后比较不同即可
    public int heightChecker(int[] A) {
        int n = A.length;
        int[] B = Arrays.copyOf(A, n);
        Arrays.sort(A);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != B[i]) count++;
        }
        return count;
    }
}
