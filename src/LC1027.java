import java.util.*;

public class LC1027 {
    //Longest Arithmetic Sequence
    //找到最大的等差数列的长度, 遍历数组, 对每一个数都对前面的数取差值, 比较差值的存在个数
    //若存在差值, 则更新当下的数的 v 的 map, 更新最长的长度
    public int longestArithSeqLength(int[] A) {
        if (A.length == 0) return 0;
        int max = 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int length = 2;
                if (map.containsKey(j) && map.get(j).containsKey(diff)) {
                    length = map.get(j).get(diff) + 1;
                }
                Map<Integer, Integer> mapDiff = map.get(i);
                mapDiff.put(diff, length);
                max = Math.max(length, max);
            }
        }
        return max;
    }
}
