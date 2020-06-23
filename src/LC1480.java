public class LC1480 {
    //1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
