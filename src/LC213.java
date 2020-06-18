import java.util.Arrays;

public class LC213 {
    //213. House Robber II
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int v1 = maxValue(nums, 1, n);
        int v2 = maxValue(nums, 0, n - 1);
        return Math.max(v1, v2);
    }

    public int maxValue(int[] A, int start, int end) {
        int n = A.length;
        int[] dp = new int[n];
        dp[start] = A[start];
        if (n == 2) return dp[start];
        dp[start + 1] = Math.max(A[start], A[start + 1]);
        if (n == 3) return dp[start + 1];
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }
        return dp[end - 1];
    }
}
