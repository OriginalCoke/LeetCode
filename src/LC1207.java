import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1207 {
    //Unique Number of Occurrences
    //频数是不重复的
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int m : map.values()) {
            if (!list.contains(m)) list.add(m);
            else return false;
        }
        return true;
    }
}
