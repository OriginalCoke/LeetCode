public class LC1470 {
    //1470. Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int x = 0, y = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[x];
                x++;
            } else {
                res[i] = nums[y];
                y++;
            }
        }
        return res;
    }
}
