import java.util.*;

public class LC102 {
    //Binary Tree Level Order Traversal
    //Amazon
    //记录每一层的数量来创建新的subList, 控制按照层数来遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            res.add(subList);
        }
        return res;
    }
}
