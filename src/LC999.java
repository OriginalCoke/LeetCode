public class LC999 {
    //Available Captures for Rook
    //先找到R,然后四个方向开始溜冰, 碰到 p 就吃掉并停止(count++), 碰到B就停止
    public int numRookCaptures(char[][] board) {
        int[] point = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    point[0] = i;
                    point[1] = j;
                    break;
                }
            }
        }
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = point[0] + dir[0];
            int y = point[1] + dir[1];
            while (x >= 0 && y >= 0 && x < 8 && y < 8 && board[x][y] == '.') {
                x += dir[0];
                y += dir[1];
            }
            if (x < 0 || y < 0 || x >= 8 || y >= 8) continue;
            if (board[x][y] == 'p') count++;
        }
        return count;
    }
}
