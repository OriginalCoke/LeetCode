import java.util.*;

public class LC98 {
    //Validate Binary Search Tree
    //Amazon
    //递归,记录每一个 node 的值作为临界值,去判断它的left和right的值是否符合二叉查找树,左子树的值应该小于父节点的值,右子树的值应该大于父节点的值
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((max != null && node.val >= max) || (min != null && node.val <= min)) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
