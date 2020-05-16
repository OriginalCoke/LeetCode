import java.util.ArrayList;
import java.util.List;

public class LC1441 {
    //Build an Array With Stack Operations
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int pointer = 1;
        for (int t : target) {
            if (t == pointer) {
                res.add("Push");
                pointer++;
            } else {
                int diff = t - pointer;
                for (int i = 0; i < diff; i++) {
                    res.add("Push");
                    res.add("Pop");
                }
                res.add("Push");
                pointer = t + 1;
            }
        }
        return res;
    }
}
