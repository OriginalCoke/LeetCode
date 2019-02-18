import java.util.*;

public class LC994 {
    //Rotting Oranges
    //BFS 遍历得到每一个烂的橘子,标记为深度为0的起点,每一轮poll出去,像四个方向延伸深度1,深度即为扩张腐烂的时间,没扩张一次深度+1时间+1
    int[] R = {-1, 0, 1, 0};
    int[] C = {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找到烂的放入队列
                if (grid[i][j] == 2) {
                    int point = i * n + j;
                    queue.offer(point);
                    depth.put(point, 0);
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int point = queue.poll();
            int row = point / n, col = point % n;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + R[i];
                int nextCol = col + C[i];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                    int nextPoint = nextRow * n + nextCol;
                    queue.offer(nextPoint);
                    depth.put(nextPoint, depth.get(point) + 1);
                    grid[nextRow][nextCol] = 2;
                    time = depth.get(nextPoint);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}
