import java.util.*;

public class LC1031 {
    //Maximum Sum of Two Non-Overlapping Subarrays
    //先计算每一步的累加和, L 和 M 的初始都从开头开始, 从 index = M + N 开始移动指针, 每次移动, 获取的数组:
    //1. 尾部保留M个长度, 一直记录前面L的长度数组的最大值; 2. 尾部保留L个长度, 一直记录前面M的长度数组的最大值.
    //比较初始在M + N - 1位置的和, 与最大的L sum 和末尾M长度数组和的最大值, 与最大的M sum 和末尾的L长度数组和的最大值
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; ++i)
            A[i] += A[i - 1];
        int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
        for (int i = L + M; i < A.length; ++i) {
            Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
        }
        return res;
    }
    //TC: O(N)
}
