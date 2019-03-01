public class LC104 {
    //Maximum Depth of Binary Tree
    //Amazon
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        return Math.max(left, right) + 1;
    }
}
