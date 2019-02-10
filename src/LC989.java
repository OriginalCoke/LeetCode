import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC989 {
    //Add to Array-Form of Integer
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1;
        while (i >= 0 || K > 0) {
            if (i >= 0) K += A[i];
            res.add(K % 10);
            K /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
        //TC: max(log K, N)   SC: max(log K, N)
    }
}
