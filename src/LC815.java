import java.util.*;

public class LC815 {
    //Bus Routes
    //最少搭乘几辆 bus, map存放的key 为stop, value 为可以到达 key 站台的 bus 路线, BFS
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int res = 0;

        if (S == T) return 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        queue.offer(S);
        while (!queue.isEmpty()) {
            int n = queue.size();
            res++;
            for (int i = 0; i < n; i++) {
                int stop = queue.poll();
                ArrayList<Integer> buses = map.get(stop);
                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return res;
                        queue.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
