import java.util.*;

public class LC259 {
    //3Sum Smaller
    //
    //先取定一个,然后双指针
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    res += hi - lo;
                    lo++;
                } else hi--;
            }
        }
        return res;
    }
}
