import java.util.*;

public class LC496 {
    //Next Greater Element I
    //用 map 记录每一个数和他后面的第一个比他大的,用stack去比较,如果有比栈里的数大的数进栈,一直 poll 直到栈顶的数比新压栈的数大
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            if (!map.containsKey(num)) nums1[i] = -1;
            else nums1[i] = map.get(num);
        }
        return nums1;
    }
}
