import java.util.Arrays;
import java.util.Comparator;

public class LC1024 {
    //Video Stitching
    //sort后对下一个 interval 的头和目前的尾进行比较, 一直记录最大的 end, 贪心记录
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });
        int n = clips.length;
        if (clips[0][0] != 0) return -1;
        int start = 0, end = clips[0][1], res = 1;
        int endMax = end;
        for (int i = 1; i < n; i++) {
            if (end >= T) return res;
            if (endMax >= T) return res + 1;
            int ts = clips[i][0], te = clips[i][1];
            if (ts > end) {
                if (ts <= endMax) {
                    res++;
                    end = endMax;
                    endMax = Math.max(endMax, te);
                } else return -1;
            } else if (ts == start) {
                endMax = te;
                if (ts == 0) end = te;
            } else {
                endMax = Math.max(endMax, te);
                start = ts;
            }
        }
        if (endMax < T) return -1;
        return res + 1;
    }
}
