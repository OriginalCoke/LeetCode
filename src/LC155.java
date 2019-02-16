import java.util.ArrayList;
import java.util.List;

public class LC155 {
    //Min Stack
    class MinStack {
        List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            int min = list.get(0);
            for (int l : list) {
                if (min > l) min = l;
            }
            return min;
        }
    }
}
