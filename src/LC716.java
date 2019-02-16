import java.util.ArrayList;
import java.util.List;

public class LC716 {
    //Max Stack
    class MaxStack {
        List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int peekMax() {
            int max = list.get(0);
            for (int l : list) if (max < l) max = l;
            return max;
        }

        public int popMax() {
            int max = peekMax(), index = -1;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == max) {
                    index = i;
                    break;
                }
            }
            list.remove(index);
            return max;
        }
    }
}
