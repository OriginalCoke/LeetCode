import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1065 {
    //Index Pairs of a String
    //前缀树或者样本量很小直接 brute force
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String s : words) {
            int index = text.indexOf(s), prev = -1, n = s.length();
            while (index >= 0) {
                int[] A = new int[2];
                A[0] = index;
                A[1] = index + n - 1;
                list.add(A);
                prev = index;
                index = text.indexOf(s, prev + 1);
            }
        }
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] pair : list) {
            res[i][0] = pair[0];
            res[i][1] = pair[1];
            i++;
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });
        return res;
    }
}
