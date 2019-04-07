import java.util.ArrayList;
import java.util.List;

public class LC1023 {
    //Camelcase Matching
    //对 pattern 的每一位去 q 的每一个字符串的 char array 找对应值
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] pt = pattern.toCharArray();
        int m = pt.length;
        List<Boolean> ret = new ArrayList<>();
        outer:
        for (String q : queries) {
            int p = 0;
            for (char c : q.toCharArray()) {
                if (p < m && pt[p] == c) {
                    p++;
                } else {
                    if (!('a' <= c && c <= 'z')) {
                        ret.add(false);
                        continue outer;
                    }
                }
            }
            ret.add(p == m);
        }
        return ret;
    }
}
