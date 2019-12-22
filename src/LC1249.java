import java.util.Stack;

public class LC1249 {
    //Minimum Remove to Make Valid Parentheses
    //stack 和数组形式都可以判断括号的匹配, 数组更快一些
    public String minRemoveToMakeValid(String s) {
        char[] A = s.toCharArray();
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A[i];
            if (c == '(' || c == ')') {
                if (stack.isEmpty() || c == '(') stack.push(i);
                else {
                    if (A[stack.peek()] == '(') stack.pop();
                    else stack.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!stack.contains(i)) sb.append(A[i]);
        }
        return sb.toString();
    }
}
