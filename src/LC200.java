public class LC200 {
    //Number of Islands
    //Amazon
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, visited, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] A, int i, int j, boolean[][] visited, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && A[i][j] == '1') {
            A[i][j] = '0';
            visited[i][j] = true;
            dfs(A, i + 1, j, visited, m, n);
            dfs(A, i - 1, j, visited, m, n);
            dfs(A, i, j + 1, visited, m, n);
            dfs(A, i, j - 1, visited, m, n);
        }
    }
}
