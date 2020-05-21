public class LC1450 {
    //1450. Number of Students Doing Homework at a Given Time
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) res++;
        }
        return res;
    }
}
