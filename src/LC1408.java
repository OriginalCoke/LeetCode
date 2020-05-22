import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1408 {
    //1408. String Matching in an Array
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String w2 = words[j];
                if (w2.contains(w1)) {
                    res.add(w1);
                    break;
                }
            }
        }
        return res;
    }
}
