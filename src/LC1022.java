public class LC1022 {
    //Sum of Root To Leaf Binary Numbers
    //二进制每增加一位, 值就是前者*2+尾数, 判断是否到尽头, 对路径进行加和
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        dfs(root, 0L);
        return (int) (ans % mod);
    }

    int mod = 1000000007;
    long ans;

    void dfs(TreeNode cur, long v) {
        if (cur == null) return;
        if (cur.left == null && cur.right == null) {
            ans += v * 2 + cur.val;
            return;
        }
        dfs(cur.left, (v * 2 + cur.val) % mod);
        dfs(cur.right, (v * 2 + cur.val) % mod);
    }
}
