import java.util.*;

public class LC103 {
    //Binary Tree Zigzag Level Order Traversal
    //Amazon
    //利用 ArrayList api, 添加的时候加入 index, list.add(index,val) ,令 index = 0 可以将后进入的值一直添加在队首
    //这样就可以一直按照层遍历从左到右读取
    //dfs 循环的部分,如果是 null 走到了叶节点就返回, 如果 size 比层数小,为了保证 size 和层数统一都是从0 开始,就新建子列表
    //取子列表进行操作,从左到右遍历,判断 level 的奇偶性进行存放
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;
        if (list.size() <= level) {
            List<Integer> addList = new ArrayList<>();
            list.add(addList);
        }
        List<Integer> temp = list.get(level);
        if (level % 2 == 0) temp.add(node.val);
        else temp.add(0, node.val);

        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }
}
