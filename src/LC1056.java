public class LC1056 {
    //Confusing Number
    //求出反转后新字符串, 比较和原来的是否一样, 如果一样返回 false,如果不能反转返回 false,如果不一样且有效返回 true
    public boolean confusingNumber(int N) {
        StringBuilder sb = new StringBuilder(N + "");
        String s = sb.reverse().toString();
        char[] C = s.toCharArray();
        for (int i = 0; i < C.length; i++) {
            char c = C[i];
            if (c == '6') C[i] = '9';
            else if (c == '9') C[i] = '6';
            else if (c == '0' || c == '1' || c == '8') continue;
            else return false;
        }
        s = String.valueOf(C);
        System.out.println(s);
        return !s.equals(N + "");
    }
}
