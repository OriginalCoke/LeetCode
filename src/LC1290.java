import java.util.ArrayList;
import java.util.List;

public class LC1290 {
    //Convert Binary Number in a Linked List to Integer
    //brute force
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += Math.pow(2, i) * list.get(index);
            index++;
        }
        return res;
    }
}
