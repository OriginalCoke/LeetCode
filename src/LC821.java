public class LC821 {
    //Shortest Distance to a Character
    //Two pass, 从前到后走一遍, 从后到前走一遍
    //第一遍从前到后:  用每一个curr的 index 减去之前的, i - prev
    //第二遍从后到前:  用每一个curr的 index 减去之后的, prev - i
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int prev = -10000;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) prev = i;
            res[i] = i - prev;
        }
        prev = 10000;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) prev = i;
            res[i] = Math.min(res[i], prev - i);
        }
        return res;
        //TC: O(N)   SC: O(N) 新建了res等长数组
    }
}
