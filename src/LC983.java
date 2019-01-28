public class LC983 {
    //Minimum Cost For Tickets
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] visited = new boolean[366];
        for (int day : days) {
            visited[day] = true;
        }
        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int i = 1; i < 366; i++) {
            if (!visited[i]) {
                minCost[i] = minCost[i - 1];
                continue;
            }
            int min;
            min = minCost[i - 1] + costs[0];
            min = Math.min(min, minCost[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, i - 30)] + costs[2]);
            minCost[i] = min;
        }
        return minCost[365];
    }
}
