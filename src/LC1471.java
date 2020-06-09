import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1471 {
    //1471. The k Strongest Values in an Array
    public int[] getStrongest(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0, lo = 0, hi = n - 1;
        int median = arr[(n - 1) / 2];
        while (count < k) {
            int dl = median - arr[lo];
            int dr = arr[hi] - median;
            if (dl <= dr) {
                list.add(arr[hi]);
                hi--;
            } else {
                list.add(arr[lo]);
                lo++;
            }
            count++;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
