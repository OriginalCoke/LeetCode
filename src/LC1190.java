import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1190 {
    //Reverse Substrings Between Each Pair of Parentheses
    //straight forward
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != ')') {
                stack.push(c);
            } else {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                for (char l : list) stack.push(l);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
