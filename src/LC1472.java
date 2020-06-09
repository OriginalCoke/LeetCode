import java.util.ArrayList;
import java.util.List;

public class LC1472 {
    //1472. Design Browser History
    class BrowserHistory {
        List<String> list;
        int current;

        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            current = 0;
        }

        public void visit(String url) {
            int size = list.size();
            for (int i = size - 1; i > current; i--) list.remove(i);
            list.add(url);
            current++;
        }

        public String back(int steps) {
            if (current >= steps) {
                current -= steps;
            } else {
                current = 0;
            }
            return list.get(current);
        }

        public String forward(int steps) {
            if (current + steps > list.size() - 1) {
                current = list.size() - 1;
            } else {
                current += steps;
            }
            return list.get(current);
        }
    }
}
