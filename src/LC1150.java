public class LC1150 {
    //Check If a Number Is Majority Element in a Sorted Array
    //binary search
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1, count = 0;
        while (lo < hi) {
            int mid = (lo + hi) / 2, v = nums[mid];
            if (target == v) {
                int left = mid, right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                    count++;
                }
                while (right < n && nums[right] == target) {
                    right++;
                    count++;
                }
                count--;
                if (count > n / 2) return true;
                return false;
            } else if (target > v) {
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return false;
    }
}