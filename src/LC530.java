import java.util.ArrayList;
import java.util.List;

public class LC530 {
    //Minimum Absolute Difference in BST
    //inorder traversal
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }
}
