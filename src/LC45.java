public class LC45 {
    //Jump Game II
    //Amazon
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1};
        System.out.println(jump(A));
    }

    public static int jump(int[] nums) {
        int n = nums.length, max = nums[0], prev = max, step = 1;
        int[] steps = new int[n];
        for (int i = 1; i < n; i++) {
            if (i > prev) {
                step++;
                prev = max;
            }
            max = Math.max(max, i + nums[i]);
            steps[i] = step;
        }
        return steps[n - 1];
    }
}
