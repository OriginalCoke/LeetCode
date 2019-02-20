import java.util.*;

public class LC56 {
    //Merge Intervals
    //Amazon
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval prev = intervals.get(0);
        int st = prev.start, end = prev.end;
        for (Interval t : intervals) {
            if (t.start > end) {
                res.add(new Interval(st, end));
                st = t.start;
                end = t.end;
            } else {
                end = Math.max(end, t.end);
            }
        }
        res.add(new Interval(st, end));
        return res;
    }
}
