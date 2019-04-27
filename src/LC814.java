public class LC814 {
    //Binary Tree Pruning
    //如果 subtree 没有 1, 只有 0, 那就把该部分变成 null, 用递归, 搜索时候如果全是 0, 就从叶节点开始变成 null
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
