public class LC53 {
    //Maximum Subarray
    //Amazon
    //sum 记录目前为止的和,如果和小于0就重置,max 记录最大值
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (sum >= 0) sum += n;
            else sum = n;
            max = Math.max(sum, max);
        }
        return max;
    }
}
