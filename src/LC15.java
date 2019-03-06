import java.util.*;

public class LC15 {
    //3Sum
    //Amazon
    //找3个数的和为0, 先找1个数,loop一遍, 剩下2个数去二分查找
    //如何排除重复的情况,不需要用contains去检验, sort之后的数列对第一个 i 的值进行除去重复, lo 与 lo+1 进行比较, hi 与 hi-1 进行比较
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) return res;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int twoSum = -nums[i];
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == twoSum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (sum > twoSum) hi--;
                else lo++;
            }
        }
        return res;
    }
}
