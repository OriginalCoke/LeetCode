import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1200 {
    //Minimum Absolute Difference
    //sort 后比较相邻两位, 即最小值
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length, minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
