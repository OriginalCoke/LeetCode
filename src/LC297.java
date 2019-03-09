import java.util.*;

public class LC297 {
    //Serialize and Deserialize Binary Tree
    //Amazon
    //把一个树变成字符串,再变回来
    //前序遍历将结果放入String,再将String通过逗号去分割成数组,重新生成树
    //用String会报错RTE,不懂
    public class Codec {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString();
        }

        public void dfs(TreeNode root, StringBuilder s) {
            if (root == null) {
                s.append("null,");
                return;
            }
            s.append(root.val + ",");
            dfs(root.left, s);
            dfs(root.right, s);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>();
            String[] vals = data.split(",");
            for (String v : vals) queue.offer(v);
            return buildTree(queue);
        }

        public TreeNode buildTree(Queue<String> queue) {
            String temp = queue.poll();
            if (temp.equals("null")) return null;
            TreeNode tn = new TreeNode(Integer.valueOf(temp));
            tn.left = buildTree(queue);
            tn.right = buildTree(queue);
            return tn;
        }
    }
}
