public class LC1060 {
    //Missing Element in Sorted Array
    //用二分改进
    public int missingElement(int[] nums, int k) {
        int start = nums[0], count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (v - start > 1) {
                int diff = v - start - 1;
                if (count + diff >= k) {
                    break;
                } else {
                    start = v;
                    count += diff;
                }
            } else start = v;
        }
        return start + k - count;
    }
}
