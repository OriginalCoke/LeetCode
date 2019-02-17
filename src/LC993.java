import java.util.*;

public class LC993 {
    //Cousins in Binary Tree
    //因为node 的值唯一不重复,用 dfs 将值K和深度V对应, 值和父节点对应,生成2个 map, 比较深度相同父节点不同
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parents;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parents = new HashMap<>();
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parents.get(x) != parents.get(y);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node.val, parent == null ? 0 : 1 + depth.get(parent.val));
            parents.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
    //TC: O(N)    SC: O(N)
}
