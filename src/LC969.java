import java.util.ArrayList;
import java.util.List;

public class LC969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int loc = findMax(A, A.length), l = A.length;
        while (l > 1) {
            if (loc != 0) {
                res.add(loc + 1);
                flip(A, loc);
            }
            res.add(l);
            flip(A, l - 1);
            l--;
            loc = findMax(A, l);
        }
        return res;
    }

    int findMax(int[] A, int index) {
        int max = Integer.MIN_VALUE, loc = 0;
        for (int i = 0; i < index; i++) {
            if (A[i] > max) {
                max = A[i];
                loc = i;
            }
        }
        return loc;
    }

    void flip(int[] arr, int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
}
