import java.util.HashMap;
import java.util.Map;

public class LC1001 {
    //Grid Illumination
    //灯光可以照亮同一行,同一列,或者两个45°方向的斜列: 同一行的 x 相同,同一列的 y 相同,2个斜角度的x-y和x+y相同
    //将其存放在map里,存取都是O(1), 记录单点被照亮的次数, 每次queries完后熄灭一盏, 熄灭其各个方向上的灯
    //8个相邻点和自身总共是9次,可以用坐标或者2个3次循环嵌套
    //不用取消0值的 map,因为查询时间一样都是O(N),难点是如何将坐标处理成一维的放进 map 做O(1)的查询处理(位运算 或 index=n*x+y 这样是唯一的, 取 x 只需要index/n, 取 y 只需要index%n)
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};
    int n;

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        n = N;
        Map<Integer, Integer> row = new HashMap();       // row number to count of lamps
        Map<Integer, Integer> col = new HashMap();       // col number to count of lamps
        Map<Integer, Integer> dg1 = new HashMap();       // diagonal x-y to count of lamps
        Map<Integer, Integer> dg2 = new HashMap();       // diagonal x+y to count of lamps
        Map<Integer, Boolean> map = new HashMap();       // whether lamp is  ON|OFF

        // increment counters while adding lamps
        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0];
            int y = lamps[i][1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            dg1.put(x - y, dg1.getOrDefault(x - y, 0) + 1);
            dg2.put(x + y, dg2.getOrDefault(x + y, 0) + 1);
            map.put(N * x + y, true);
        }

        int[] res = new int[queries.length];
        // address queries
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            res[i] = (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || dg1.getOrDefault(x - y, 0) > 0 || dg2.getOrDefault(x + y, 0) > 0) ? 1 : 0;
            // switch off the lamps, if any
            for (int d = 0; d < dirs.length; d++) {
                int x1 = x + dirs[d][0];
                int y1 = y + dirs[d][1];
                if (isValid(x1, y1) && map.containsKey(N * x1 + y1) && map.get(N * x1 + y1)) {
                    // the lamp is on, turn it off, so decrement the count of the lamps
                    row.put(x1, row.getOrDefault(x1, 1) - 1);
                    cut(row, x1);
                    col.put(y1, col.getOrDefault(y1, 1) - 1);
                    cut(col, y1);
                    dg1.put(x1 - y1, dg1.getOrDefault(x1 - y1, 1) - 1);
                    cut(dg1, x1 - y1);
                    dg2.put(x1 + y1, dg2.getOrDefault(x1 + y1, 1) - 1);
                    cut(dg2, x1 + y1);
                    map.put(N * x1 + y1, false);
                }
            }
        }

        return res;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    private void cut(Map<Integer, Integer> map, int k) {
        if (map.get(k) == 0) map.remove(k);
    }
}
