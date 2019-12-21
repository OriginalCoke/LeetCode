public class LC322 {
    //Coin Change
    //iterative dp
    //求 1-amount 所需的硬币数量, 每次判断当前的 amount 是否能找到币值符合的, 再之前的基础上+1
    public int coinChange(int[] coins, int amount) {
        //初始化数组, 代表每一个钱币总数的最小所需硬币数
        int[] dp = new int[amount + 1];
        int curr = 1;
        while (curr <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (curr >= coin && dp[curr - coin] >= 0) {
                    //如果存在硬币面值差, 则只需要一枚差值的硬币 coin 补上, 剩余的蔚 curr-coin 的枚数
                    int temp = dp[curr - coin] + 1;
                    //记录到 curr 的最小所需硬币数量
                    if (min < 0 || temp < min) min = temp;
                }
            }
            dp[curr] = min;
            curr++;
        }
        return dp[amount];
    }
}
