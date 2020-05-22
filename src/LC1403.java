import java.util.*;

public class LC1403 {
    //1403. Minimum Subsequence in Non-Increasing Order
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int num : nums) sum += num;
        int sub = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int v = nums[i];
            res.add(v);
            sub += v;
            sum -= v;
            if (sub > sum) break;
        }
        return res;
    }
}
