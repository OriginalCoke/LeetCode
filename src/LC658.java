import java.util.*;

public class LC658 {
    //Find K Closest Elements
    //先分段,取定长度为 k 的区间一直移动
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(arr[left + i]);
        return res;
    }
}
