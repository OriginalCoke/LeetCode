import java.util.*;

public class LC783 {
    //Minimum Distance Between BST Nodes
    //中序遍历
    public int minDiffInBST(TreeNode root) {
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
