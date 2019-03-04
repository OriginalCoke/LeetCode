import java.util.*;

public class LC1002 {
    //Find Common Characters
    //
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String a : A) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : a.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            list.add(map);
        }
        Map<Character, Integer> first = list.get(0);

        for (Character ch : first.keySet()) {
            int min = Integer.MAX_VALUE;
            for (Map<Character, Integer> m : list) {
                if (!m.containsKey(ch)) {
                    min = 0;
                    break;
                } else min = Math.min(min, m.get(ch));
            }
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    res.add(ch + "");
                }
            }
        }
        return res;
    }
}
