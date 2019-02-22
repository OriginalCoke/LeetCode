import java.util.*;

public class LC20 {
    //Valid Parentheses
    //Amazon
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String p = "{[(", q = "}])";
        for (char c : s.toCharArray()) {
            String temp = c + "";
            if (p.contains(temp)) stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                int index = q.indexOf(c);
                if (stack.pop() != p.charAt(index)) return false;
            }
        }
        return stack.isEmpty();
    }
}
