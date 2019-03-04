import java.util.Stack;

public class LC1003 {
    //Check If Word Is Valid After Substitutions
    //
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == 'a') stack.push(ch);
            else if (ch == 'b') {
                if (stack.isEmpty() || stack.peek() != 'a') return false;
                else {
                    stack.pop();
                    stack.push(ch);
                }
            } else {
                if (stack.isEmpty() || stack.peek() != 'b') return false;
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
