import java.util.Arrays;

public class LC1464 {
    //1464. Maximum Product of Two Elements in an Array
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
