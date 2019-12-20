import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1265 {
    //Print Immutable Linked List in Reverse
    //recursive
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
