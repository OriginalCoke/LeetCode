import java.util.*;

public class LC239 {
    //Sliding Window Maximum
    //deque存放 index 去作为移窗, 先判断 deque 里的值是否都在移窗的范围内, 如果不在从头部出去, 其次判断后来的数是否大于在移窗范围内的已有的数
    //如果比原有的大, 则把原有的扔出去, 因为窗子一直向右移动, 原有的数会失效; 如果小, 放入, 若后续移窗, 则头部出去, 小的数会被轮到
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (nums == null || k <= 0) return res;
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[index] = nums[q.peek()];
                index++;
            }
        }
        return res;
    }
}
