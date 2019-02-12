public class LC643 {
    //Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, index = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int max = sum;
        while (index + k < nums.length) {
            sum = sum - nums[index] + nums[index + k];
            max = Math.max(sum, max);
            index++;
        }
        return (double) max / k;
    }
}
