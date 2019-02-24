public class LC997 {
    //Find the Town Judge
    //如果被信任,bucket++, 信任别人 bucket--
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
