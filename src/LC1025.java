public class LC1025 {
    //Divisor Game
    //DP, 对起始的因子进行赋值, 往后遍历, 若Alice走出第一步后, 可以有i-j为 false 的已经确定的前面的值, 则Alice会获胜, 遍历中断
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (dp[i - j] == false) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }
}
