import java.util.*;

public class LC875 {
    //Koko Eating Bananas
    //对吃香蕉个数的最小到最大进行二分,与数组原本的值无关, 从 1 到数组 max 进行二分, 若满足时间在 H 以内,则缩小范围
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);
        while (lo < hi) {
            int mid = (lo + hi) / 2, hrs = 0;
            for (int p : piles) {
                if (p % mid == 0) hrs += p / mid;
                else hrs += p / mid + 1;
                if (hrs > H) break;
            }
            if (hrs > H) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
