public class LC1041 {
    //Robot Bounded In Circle
    //方向转向, 每次提前对朝向和状态进行计算, 下一个循环进行移位, 然后再转向
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, i = 0;
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int j = 0; j < instructions.length(); j++)
            if (instructions.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (instructions.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0];
                y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }
}
