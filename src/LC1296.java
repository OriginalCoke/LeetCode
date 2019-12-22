import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1296 {
    //Divide Array in Sets of K Consecutive Numbers
    //排序后贪心
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) > 0) {
                for (int j = 0; j < k; j++) {
                    int key = nums[i] + j;
                    if (!map.containsKey(key)) {
                        return false;
                    }
                    if (map.get(key) <= 0) {
                        return false;
                    }
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        return true;
    }
}
