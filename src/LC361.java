public class LC361 {
    //Bomb Enemy
    //Google
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, max = 0, rowEnermy = 0;
        int[] colEnermy = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') rowEnermy = helper1(grid, i, j);
                if (i == 0 || grid[i - 1][j] == 'W') colEnermy[j] = helper2(grid, i, j);
                if (grid[i][j] == '0') max = Math.max(max, rowEnermy + colEnermy[j]);
            }
        }
        return max;
    }

    private int helper2(char[][] grid, int i, int j) {
        int num = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }

    private int helper1(char[][] grid, int i, int j) {
        int num = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
}
