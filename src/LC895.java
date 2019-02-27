import java.util.*;

public class LC895 {
    //Maximum Frequency Stack
    //Amazon
    //每进去一个数统计其频率,对频率进行排序,频率高的先出来
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> order;
        int max = 0;

        public FreqStack() {
            freq = new HashMap<>();
            order = new HashMap<>();
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            max = Math.max(f, max);
            if (!order.containsKey(max)) order.put(max, new Stack<>());
            order.get(f).add(x);
        }

        public int pop() {
            int res = order.get(max).pop();
            freq.put(res, max - 1);
            if (order.get(max).size() == 0) max--;
            return res;
        }
    }
}
