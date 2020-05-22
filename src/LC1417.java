import java.util.ArrayList;
import java.util.List;

public class LC1417 {
    //1417. Reformat The String
    public String reformat(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') digits.add(c);
            else letters.add(c);
        }
        if (Math.abs(digits.size() - letters.size()) > 1) return "";
        int n = Math.min(digits.size(), letters.size());

        for (int i = 0; i < n; i++) {
            sb.append(digits.get(i));
            sb.append(letters.get(i));
        }
        if (digits.size() > letters.size()) sb.append(digits.get(n));
        else if (digits.size() < letters.size()) sb.reverse().append(letters.get(n));
        return sb.toString();
    }
}
