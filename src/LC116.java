import java.util.*;

public class LC116 {
    //Populating Next Right Pointers in Each Node
    //Amazon
    //BFS 和递归都可以,next 默认值就是 null 不用去赋值,对指针进行移动
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    public void helper(Node root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}
