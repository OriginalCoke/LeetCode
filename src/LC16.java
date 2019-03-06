import java.util.*;

public class LC16 {
    //3Sum Closest
    //Amazon
    //先锁定一个,然后去双指针比较大小
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, diff = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) return target;
                else if (sum > target) {
                    hi--;
                } else lo++;
                if (diff > Math.abs(sum - target)) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }
}
