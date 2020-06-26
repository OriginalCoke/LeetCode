import java.util.*;

public class LC1477 {
    //1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
    //先找到两个子数组的和为 target, 再找最小的子数组长度和
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, n = arr.length;
        int minSize = n + 1, res = n + 1;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) minSize = Math.min(minSize, i - map.get(sum - target));
            if (map.containsKey(sum + target) && minSize < n + 1)
                res = Math.min(res, map.get(sum + target) - i + minSize);
        }
        return res > n ? -1 : res;
    }
}
