import java.util.*;

public class LC988 {
    //Smallest String Starting From Leaf
    String res = "{";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            String temp = sb.reverse().toString();
            if (temp.compareTo(res) < 0) res = temp;
            sb.reverse();
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
