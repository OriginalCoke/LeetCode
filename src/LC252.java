import java.util.*;

public class LC252 {
    //Meeting Rooms
    //Amazon
    //比较interval重合情况
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            Interval head = intervals[i], tail = intervals[i + 1];
            if (head.end > tail.start) return false;
        }
        return true;
        //O(NlogN)
    }
}
