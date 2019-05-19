import java.util.Stack;

public class LC1047 {
    //Remove All Adjacent Duplicates In String
    //stack
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (stack.peek() == c) {
                    stack.pop();
                } else stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
