public class LC55 {
    //Jump Game
    //Amazon
    //初始化max,每次记录每个点到达的最远位置,如果到不了该点就 false,如果能到就更新新的最大值
    public boolean canJump(int[] nums) {
        int max = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            if (max >= n - 1) return true;
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            } else return false;
        }
        return true;
    }
}
