import java.util.*;

public class LC1019 {
    //Next Greater Node In Linked List
    //用 stack 去存,同数组的思路
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(0);
        map.put(0, head.val);
        int index = 1;
        head = head.next;
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int[] res = new int[count + 1];
        while (head != null) {
            int val = head.val;
            map.put(index, val);
            while (!stack.isEmpty() && val > map.get(stack.peek())) {
                res[stack.pop()] = val;
            }
            stack.push(index);
            head = head.next;
            index++;
        }
        return res;
    }
}
