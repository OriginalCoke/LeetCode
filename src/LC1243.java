import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1243 {
    //Array Transformation
    //brute force?
    public List<Integer> transformArray(int[] arr) {
        int n = arr.length;
        boolean f = true;
        while (f) {
            f = false;
            int[] temp = Arrays.copyOf(arr, n);
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    temp[i]++;
                    f = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    temp[i]--;
                    f = true;
                }
            }
            arr = temp;
        }
        List<Integer> res = new ArrayList<>();
        for (int a : arr) res.add(a);
        return res;
    }
}
