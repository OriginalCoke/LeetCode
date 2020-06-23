import java.util.*;

public class LC1487 {
    //1487. Making File Names Unique
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : names) map.put(s, 1);
        for (int i = 0; i < n; i++) {
            String s = names[i];
            if (!set.contains(s)) {
                res[i] = s;
                set.add(s);
            } else {
                int index = map.get(s);
                while (true) {
                    String suf = s + "(" + index + ")";
                    if (set.contains(suf)) index++;
                    else {
                        res[i] = suf;
                        set.add(suf);
                        map.put(s, index + 1);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
