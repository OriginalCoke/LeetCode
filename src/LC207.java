import java.util.*;

public class LC207 {
    //Course Schedule
    //新建二维数组记录相对关系,没有前置为0,有前置为1
    //记录每一门课的前置课程的数量
    public boolean canFinish(int n, int[][] prerequisites) {
        boolean[][] isPre = new boolean[n][n];
        int[] numPre = new int[n];
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            int pre = prerequisites[i][1], post = prerequisites[i][0];
            if (!isPre[pre][post]) numPre[post]++;
            isPre[pre][post] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (numPre[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < n; i++) {
                if (isPre[course][i]) {
                    numPre[i]--;
                    if (numPre[i] == 0) queue.offer(i);
                }
            }
        }
        return count == n;
    }
}
