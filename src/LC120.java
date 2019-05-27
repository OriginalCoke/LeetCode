import java.util.List;

public class LC120 {
    //Triangle
    //每一层向下, 每一个 index 的相邻为下一行的 i 和 i+1, DP 记录最小值
    //为了实现 SC:O(1), 从最后一行往前遍历, 每次取出上一行相邻 2 个的最小值, 加上目前这一行 index 后的值, 直接在 res 结果数组上进行更新
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
