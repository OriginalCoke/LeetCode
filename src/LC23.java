import java.util.*;

public class LC23 {
    //Merge k Sorted Lists
    //Amazon
    //一种方法是把所有的数取出来放进 list 里sort一下,然后建立新的ListNode, 时间复杂度nlogn
    //用优先队列去存储每一个节点,进队的时候会排序
    //难点是进入循环后如何一个一个取出node的 val 去比较,每次将指针指向下一个,将指针此时的新队列,队头是下一个 node,放入队列重新排队
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        ListNode dummy = new ListNode(0), head = dummy;
        for (ListNode ln : lists) {
            if (ln != null) queue.offer(ln);
        }
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null) queue.offer(head.next);
        }
        return dummy.next;
    }
}
