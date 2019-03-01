public class LC572 {
    //Subtree of Another Tree
    //Amazon
    //树的题目很生疏,做了不少,但是思路还是很少,对递归的过程很不熟悉
    //遍历母树 s, 判断 t 是否和s 的片段相等
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    //TC: O(m*n)
}
