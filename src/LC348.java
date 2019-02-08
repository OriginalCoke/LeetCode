public class LC348 {
    //Design Tic-Tac-Toe
    //Google
    class TicTacToe {
        int[][] grid;

        public TicTacToe(int n) {
            grid = new int[n][n];
        }

        public int move(int row, int col, int player) {
            int n = grid.length;
            grid[row][col] = player;
            // System.out.println(grid[0][0]);
            boolean f = true;
            for (int i = 0; i < n; i++) {
                if (grid[i][col] != player) {
                    f = false;
                    break;
                }
            }
            if (f) return player;
            f = true;
            for (int j = 0; j < n; j++) {
                if (grid[row][j] != player) {
                    f = false;
                    break;
                }
            }
            if (f) return player;
            if (row != col && row + col != n - 1) return 0;
            f = true;
            if (row == col) {
                for (int i = 0; i < n; i++) {
                    if (grid[i][i] != player) {
                        f = false;
                        break;
                    }
                }
                if (f) return player;
            }
            f = true;
            if (row + col == n - 1) {
                for (int i = 0; i < n; i++) {
                    if (grid[i][n - 1 - i] != player) {
                        f = false;
                        break;
                    }
                }
                if (f) return player;
            }
            return 0;
        }
    }
}
