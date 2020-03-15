import java.util.*;

public class LC1331 {
    //Rank Transform of an Array
    //用 rank 代替数, 相等的数 rank 相等
    //n*log(n) 会 TLE
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] A = Arrays.copyOf(arr, n);
        Arrays.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.putIfAbsent(a, map.size() + 1);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
