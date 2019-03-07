public class LC86 {
    //Partition List
    //Amazon
    //把所有小于目标 x 的数移到最前一个大于等于 x 的数前,保持原列表其他位置的数不变
    //想先找到第一个比x大或相等的数,然后再走一遍把比它小的全部放到前面,但这是链表就比较麻烦
    //建2个列表,一个存放小于的数,一个存放大于等于的,只要保持相对位置不变就行,空间复杂度较大
    //主要是链表的使用,如何用多余的头去指向下一个,如何移动指针
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0), curr1 = dummy1, curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
