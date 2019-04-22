import java.util.*;
import java.util.Arrays;

public class LC1029 {
    //Two City Scheduling
    //两者的总和是不变的, 求各半的最小值, 可以考虑减去最大值, 每一个值都取A和B城市的费用差, 按照费用差从小到大排序
    //排在前面的一半说明到A费用更小, 后面的一半到B费用更小
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - a[1] - (b[0] - b[1]);
            }
        });
        int n = costs.length, half = n / 2, res = 0;
        for (int i = 0; i < half; i++) res += costs[i][0];
        for (int i = half; i < n; i++) res += costs[i][1];
        return res;
    }
    //TC: nlog(n)      SC: O(1)
}
