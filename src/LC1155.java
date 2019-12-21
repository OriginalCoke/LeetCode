public class LC1155 {
    //Number of Dice Rolls With Target Sum
    //dp
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > i * f) {
                    break;
                } else {
                    for (int k = 1; k <= f && k <= j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[d][target];
    }
}
