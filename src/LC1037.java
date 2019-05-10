public class LC1037 {
    //Valid Boomerang
    //直接按照题意全部取出进行比较, 比较两两计算后的斜率是否相等, 比较点是否独立不重合
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int x2 = points[1][0];
        int x3 = points[2][0];
        int y1 = points[0][1];
        int y2 = points[1][1];
        int y3 = points[2][1];
        if ((y3 - y2) * (x3 - x1) == (y3 - y1) * (x3 - x2)) return false;
        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) return false;
        return true;
    }
}
