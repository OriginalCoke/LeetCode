import java.util.*;

public class LC24 {
    //Swap Nodes in Pairs
    //指针变换: 1. 第一个节点指向第二个节点的后一位; 2. 头结点指向第二个节点; 3. 头结点的后一位的后一位指向第一个节点; 4. 指针移动到第二组
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
    //所有节点都遍历一遍, TC: O(N)
}
