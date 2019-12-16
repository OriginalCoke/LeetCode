import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1272 {
    //Remove Interval
    //分情况讨论, 减少判断语句重复
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        int left = toBeRemoved[0], right = toBeRemoved[1];
        for (int i = 0; i < n; i++) {
            int a = intervals[i][0], b = intervals[i][1];
            if (b <= left || right <= a) {
                res.add(Arrays.asList(a, b));
            } else if (left >= a) {
                if (a != left) {
                    res.add(Arrays.asList(a, left));
                }
                if (right <= b && right != b) {
                    res.add(Arrays.asList(right, b));
                }
            } else {
                if (right < b) {
                    res.add(Arrays.asList(right, b));
                }
            }
        }
        return res;
    }
}
