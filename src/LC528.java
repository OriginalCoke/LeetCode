import java.util.*;

public class LC528 {
    //Random Pick with Weight
    //记录每一步的暂时总和, 最后去二分, 注意边界条件和返回值
    int[] A;
    int count;

    public LC528(int[] w) {
        A = new int[w.length];
        int curr = 0, i = 0;
        for (int num : w) {
            curr += num;
            A[i] = curr;
            i++;
        }
        count = curr;
    }

    public int pickIndex() {
        int index = new Random().nextInt(count);
        index++;
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int val = A[mid];
            if (index == val) return mid;
            else if (index > val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
