import java.util.Arrays;
import java.util.Comparator;

public class LC1365 {
    //1365. How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        Pair[] A = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(i, nums[i]);
            A[i] = pair;
        }
        Arrays.sort(A, Comparator.comparingInt(o -> o.b));
        int[] res = new int[n];
        int rank = 0;
        res[A[0].a] = 0;
        for (int i = 1; i < n; i++) {
            if (A[i].b != A[i - 1].b) rank = i;
            res[A[i].a] = rank;
        }
        return res;
    }

    class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
