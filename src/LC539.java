import java.util.Arrays;
import java.util.List;

public class LC539 {
    //Minimum Time Difference
    //转换格式, sort 后比较相邻的最小值, 再比较首尾环状差的最小值
    //用 bucket sort 可以将直接 Sort 的时间复杂度从 nlogn 降到 n
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] A = new int[n];
        int index = 0;
        for (String s : timePoints) {
            String[] v = s.split(":");
            A[index] = Integer.parseInt(v[0]) * 60 + Integer.parseInt(v[1]);
            index++;
        }
        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(A[i] - A[i - 1], minDiff);
        }
        minDiff = Math.min(A[0] + 24 * 60 - A[n - 1], minDiff);
        return minDiff;
    }
}
