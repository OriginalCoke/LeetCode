import java.util.*;

public class LC662 {
    //Maximum Width of Binary Tree
    //计算二叉树的最大宽度,找到每一层的第一个和最后一个的位置即可
    //将 root 作为1,开始按照层去标记,依次+1,计算第一个有效节点的自身位置,计算最后一个有效节点的自身位置
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size(), start = 0, end = 0, curW;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) start = map.get(node);
                if (i == size - 1) end = map.get(node);
                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
}
