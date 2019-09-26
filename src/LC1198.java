public class LC1198 {
    //Find Smallest Common Element in All Rows
    //每一行进行查找, 指针在列上, 因为是升序数组, 找到最小的相对于其他列的 max, 比较 max 是否存在, 如果不存在更新 max
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] p = new int[m];
        int max = mat[0][0];
        for (int i = 1; i < m; i++) {
            max = Math.max(max, mat[i][0]);
        }
        while (true) {
            int nextMax;
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                while (p[i] < n && mat[i][p[i]] < max) {
                    p[i]++;
                    flag = false;
                    if (p[i] == n) return -1;
                }
                nextMax = mat[i][p[i]];
                max = nextMax;
            }
            if (flag) break;
        }
        return max;
    }
}
