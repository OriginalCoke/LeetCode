import java.util.*;

public class LC340 {
    //Longest Substring with At Most K Distinct Characters
    //先找到第一个, 再继续移窗?
    //从 index=0 起始, 右指针不断向右移动, 如果窗口不符合条件, 左指针开始移动
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] bucket = new int[256];
        int left = 0, res = 0, n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            if (bucket[index] == 0) count++;
            bucket[index]++;
            while (count > k) {
                index = s.charAt(left);
                bucket[index]--;
                if (bucket[index] == 0) count--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
