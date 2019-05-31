public class LC746 {
    //Min Cost Climbing Stairs
    //DP, 一次可以走 1 步或 2 步, 记录两种情况和的最小值
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 2) res[i] = 0;
            else res[i] = Math.min(res[i - 1] + cost[i - 1], res[i - 2] + cost[i - 2]);
        }
        int minCost = res[n];
        return minCost;
    }
}
