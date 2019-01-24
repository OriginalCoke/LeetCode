public class LC979 {
    //Distribute Coins in Binary Tree
    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    //left and right 是代表流量,也就是每个节点val-1来实现自己的节点先到达平衡,从 dfs 的最尾端开始往回递归
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
