import java.util.Arrays;

public class LC1388 {
    //1388. Pizza With 3n Slices
    //只要相隔就能实现 pick, 但首尾是特殊情况, 因为是环状, 所以第一个和最后一个也不能相连
    //对于长度为 m 的数组, 考虑 0~m-2 的最大值, 考虑 1~m-1 的最大值

    /**
     * 只要相隔就是符合条件
     * 首尾不能相连, 因为是环状
     * dp 设置考虑所取的数量到 1/3length,
     */
    public int maxSizeSlices(int[] slices) {
        int m = slices.length, n = m / 3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, m - 1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, m);
        return Math.max(maxSum(slices1, n), maxSum(slices2, n));
    }

    int maxSum(int[] arr, int n) {
        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        //i 是数组长度, j 是选择的数量
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = arr[0];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + arr[i - 1]);
                }
            }
        }
        return dp[m][n];
    }
}