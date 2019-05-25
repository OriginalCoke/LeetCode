import java.util.*;

public class LC1036 {
    //Escape a Large Maze
    //Maze很大, 起点和终点是同级的, 有可能起点被包围, 有可能终点被包围, 因此要考虑两种情况, BFS 和 DFS 都可以, 判断最大的被 block 围圈的情况
    //当所有的 block 是斜对角时候被围面积最大, 只需要判断数量是否超过即可
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return bfs(blocked, source, target) && bfs(blocked, target, source);
    }

    public boolean bfs(int[][] blocked, int[] source, int[] target) {
        long r = 1000000;
        long c = 1000000;

        Set<Long> blockedSet = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            blockedSet.add(c * blocked[i][0] + blocked[i][1]);
        }
        int n = blocked.length;

        Queue<Long> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        long sourcePos = c * source[0] + source[1];
        long endPos = c * target[0] + target[1];
        if (blockedSet.contains(sourcePos)) return false;

        visited.add(sourcePos);
        queue.offer(sourcePos);

        int[] nextX = new int[]{0, 0, 1, -1};
        int[] nextY = new int[]{-1, 1, 0, 0};

        int count = 1;
        while (!queue.isEmpty()) {
            long index = queue.poll();
            long x = index / c;
            long y = index % c;

            for (int i = 0; i < 4; i++) {
                long x1 = x + nextX[i];
                long y1 = y + nextY[i];

                if (x1 < 0 || y1 < 0 || x1 >= r || y1 >= c) continue;
                long v = c * x1 + y1;
                if (!blockedSet.contains(v) && !visited.contains(v)) {
                    if (v == endPos) return true;
                    visited.add(v);
                    queue.offer(v);
                    count++;
                }
            }
            if (count > n * n / 2) {
                return true;
            }
        }
        return false;
    }
}
