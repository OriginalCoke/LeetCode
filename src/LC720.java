import java.util.*;

public class LC720 {
    //Longest Word in Dictionary
    //sort 一下使其字母表升序,判断是否每一个紧跟的后者包含了前者的substring(0,len-1)
    public String longestWord(String[] words) {
        String res = "";
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                set.add(w);
                if (res.length() < w.length()) res = w;
            }
        }
        return res;
    }
    //TC: sort NlogN
}
