import java.util.Stack;

public class LC1221 {
    //Split a String in Balanced Strings
    //find the minimum sequence using greedy
    public int balancedStringSplit(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (c == top) {
                    stack.push(c);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) res++;
                }
            }
        }
        return res;
    }
}
