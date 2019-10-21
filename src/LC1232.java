public class LC1232 {
    //Check If It Is a Straight Line
    //检查斜率
    public boolean checkStraightLine(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n - 2; i++) {
            if ((A[i + 1][1] - A[i][1]) * (A[i + 2][0] - A[i + 1][0]) != (A[i + 2][1] - A[i + 1][1]) * (A[i + 1][0] - A[i][0]))
                return false;
        }
        return true;
    }
}
