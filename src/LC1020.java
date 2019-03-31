public class LC1020 {
    //Number of Enclaves
    //DFS
    int m, n, count;
    boolean f;

    public int numEnclaves(int[][] A) {
        m = A.length;
        n = A[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f = false;
                count = 0;
                if (!visited[i][j] && A[i][j] == 1) {
                    dfs(A, i, j, visited);
                    if (!f) res += count;
                }
            }
        }
        return res;
    }

    void dfs(int[][] A, int i, int j, boolean[][] v) {
        if (i < 0 || j < 0 || i >= m || j >= n || v[i][j] || A[i][j] == 0) return;
        v[i][j] = true;
        count++;
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) f = true;
        dfs(A, i + 1, j, v);
        dfs(A, i - 1, j, v);
        dfs(A, i, j + 1, v);
        dfs(A, i, j - 1, v);
    }
}
