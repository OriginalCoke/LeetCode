public class LC1266 {
    //Minimum Time Visiting All Points
    //the max difference between the abs value of row and column index
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int n = points.length;
        int[] pair = points[0];
        for (int i = 1; i < n; i++) {
            int[] temp = points[i];
            res += (Math.max(Math.abs(temp[0] - pair[0]), Math.abs(temp[1] - pair[1])));
            pair = temp;
        }
        return res;
    }
}
