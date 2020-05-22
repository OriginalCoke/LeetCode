public class LC1413 {
    //1413. Minimum Value to Get Positive Step by Step Sum
    public int minStartValue(int[] nums) {
        int n = nums.length, sum = nums[0], min = sum;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if (1 - min <= 0) return 1;
        else return 1 - min;
    }
}
