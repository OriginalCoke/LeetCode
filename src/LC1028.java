import java.util.*;

public class LC1028 {
    //Recover a Tree From Preorder Traversal
    //递归或者迭代, 对层数进行计算, 前序遍历: root->left->right, 赋值的顺序也是同样
    //迭代: 遍历字符串, 通过 dash 的个数计算层数, 如果来到下一层, 则通过对象关系将新的节点与上一层进行连接,
    //因为是前序遍历, 因此先判断是否左节点为空, 再判断右节点是否为空, 最后通过对象关系返还 root, 也就是 map 的 key 在 0 层时候的 v 值
    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> levels = new HashMap<>();
        int i = 0;
        //1-2--3--4-5--6--7
        while (i < S.length()) {
            int curLevel = 0, val = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                curLevel++;
                i++;
            }
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            levels.put(curLevel, node);
            if (curLevel > 0) {
                TreeNode parent = levels.get(curLevel - 1);
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }
        }
        return levels.get(0);
    }
}
