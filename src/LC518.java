import java.util.Arrays;

public class LC518 {
    //Coin Change 2
    //不同于 coin change 1的是求所有情况, 不是最小数量
    //dp[0]=1 使得每次的初始 coin==i 时候赋值为 1
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
