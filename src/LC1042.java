import java.util.*;

public class LC1042 {
    //Flower Planting With No Adjacent
    //先开始觉得有点像 union find, 但是穷举即可
    //先用 map 存取相对关系, 是双向无权图, 存取对应连接关系即可, 对 color 进行初始化, 将已经有的关系图的 color 删除, 存取 i-1 的颜色
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) map.put(i, new HashSet<>());
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            for (int m : map.get(i)) {
                list.remove(new Integer(res[m - 1]));
            }
            res[i - 1] = list.get(0);
        }
        return res;
    }
}
