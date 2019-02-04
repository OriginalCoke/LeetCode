import java.util.ArrayList;
import java.util.List;

public class LC986 {
    //Interval List Intersections
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i].start, B[j].start), hi = Math.min(A[i].end, B[j].end);
            if (lo <= hi) res.add(new Interval(lo, hi));
            if (A[i].end < B[j].end) i++;
            else j++;
        }
        return res.toArray(new Interval[res.size()]);
    }
}
