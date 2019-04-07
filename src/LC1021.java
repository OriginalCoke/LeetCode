public class LC1021 {
    //Remove Outermost Parentheses
    //输入的括号是匹配正确的, 不需要用 stack 去存放, 直接挪动指针即可
    public String removeOuterParentheses(String S) {
        char[] s = S.toCharArray();
        int h = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c == '(') {
                if (h > 0) {
                    sb.append(c);
                }
                h++;
            } else {
                if (h > 1) {
                    sb.append(c);
                }
                h--;
            }
        }
        return sb.toString();
    }
}
