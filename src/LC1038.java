public class LC1038 {
    //Binary Search Tree to Greater Sum Tree
    //每一个值都变成比它大的所有的值, 并加上自身的值
    //中序遍历二叉树
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.right);
        node.val += sum;
        sum = node.val;
        traverse(node.left);
    }
}
