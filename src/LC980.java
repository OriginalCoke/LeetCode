public class LC980 {
    //Unique Paths III
    //sx for startX, sy for startY, ex for endX, ey for endY
    int res = 0, empty = 1, sx, sy, ex, ey;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy, m, n);
        return res;
    }

    //backtracking
    public void dfs(int[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] < 0) return;
        if (x == ex && y == ey && empty == 0) {
            res++;
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfs(grid, x + 1, y, m, n);
        dfs(grid, x - 1, y, m, n);
        dfs(grid, x, y + 1, m, n);
        dfs(grid, x, y - 1, m, n);
        grid[x][y] = 0;
        empty++;
    }

}
