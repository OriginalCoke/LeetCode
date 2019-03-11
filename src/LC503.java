import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC503 {
    //Next Greater Element II
    //建立一个2倍长度的数组去做一个完整循环?
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                map.put(stack.pop(), i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) res[i] = nums[map.get(i)];
            else res[i] = -1;
        }
        return res;
    }
}
