public class LC1026 {
    //Maximum Difference Between Node and Ancestor
    //最大差是绝对值形式, 每次保持记录最大值和最小值, 对每一个遍历到的节点进行比较差值, 一直更新全局变量res
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    void dfs(TreeNode cur, int max, int min) {
        if (cur == null) return;
        res = Math.max(res, Math.abs(max - cur.val));
        res = Math.max(res, Math.abs(min - cur.val));

        dfs(cur.left, Math.max(max, cur.val), Math.min(min, cur.val));
        dfs(cur.right, Math.max(max, cur.val), Math.min(min, cur.val));
    }
}
