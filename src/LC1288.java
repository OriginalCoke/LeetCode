import java.util.Arrays;
import java.util.Comparator;

public class LC1288 {
    //Remove Covered Intervals
    //greedy
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (right >= intervals[i][1]) count++;
            else right = intervals[i][1];
        }
        return n - count;
    }
}
