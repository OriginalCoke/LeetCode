import java.util.*;

public class LC1128 {
    //Number of Equivalent Domino Pairs
    //x*r+y
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(numEquivDominoPairs(A));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int v = d[0] * 9 + d[1];
            if (d[0] > d[1]) v = d[1] * 9 + d[0];
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int res = 0;
        for (int v : map.values()) {
            if (v > 1) {
                res += v * (v - 1) / 2;
            }
        }
        return res;
    }
}
