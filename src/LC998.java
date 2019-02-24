public class LC998 {
    //Maximum Binary Tree II
    //对右子树进行递归, 如果大于 val 则继续, 如果小则将current node变为新 val 的左子树
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
