public class LC1043 {
    //Partition Array for Maximum Sum
    //先开始认为是移窗, 但题目要求 partition 后取每一段的最大值, DP
    //dp数组记录下标移动到该位的最大值, 每一个下标移动后, 先记录当下的 current max 值, 然后对 K-1 长度的移窗进行计算
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];

        for (int i = 1; i < n; i++) {
            int maxSum = A[i] + dp[i - 1];
            int maxVal = A[i];
            for (int j = i - 1; j >= 0 && j > i - K; j--) {
                maxVal = Math.max(maxVal, A[j]);
                if (j == 0) {
                    maxSum = Math.max(maxSum, maxVal * (i + 1));
                } else {
                    maxSum = Math.max(maxVal * (i - j + 1) + dp[j - 1], maxSum);
                }

            }
            dp[i] = maxSum;
        }

        return dp[n - 1];
    }
}
