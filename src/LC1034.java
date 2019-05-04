public class LC1034 {
    //Coloring A Border
    //需要判断是否在四个方向都是原色
    private int[] d = {0, 1, 0, -1, 0};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        dfs(grid, r0, c0, grid[r0][c0]);
        for (int[] g : grid) {
            for (int i = 0; i < g.length; ++i) {
                if (g[i] < 0) {
                    g[i] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int r, int c, int clr) {
        grid[r][c] = -clr;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int x = r + d[i], y = c + d[i + 1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || Math.abs(grid[x][y]) != clr) {
                continue;
            }
            count++;
            if (grid[x][y] == clr) {
                dfs(grid, x, y, clr);
            }
        }
        if (count == 4) {
            grid[r][c] = clr;
        }
    }
}
