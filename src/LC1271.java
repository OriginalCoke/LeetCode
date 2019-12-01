public class LC1271 {
    //Hexspeak
    //不强转类型的做法?
    //16 进制求法
    public String toHexspeak(String num) {
        int reminder;
        String s = "ABCDEF";
        StringBuilder sb = new StringBuilder();
        long a = Long.parseLong(num);
        while (a > 0) {
            reminder = (int) (a % 16);
            if (reminder > 1 && reminder < 10) return "ERROR";
            if (reminder == 1) sb.append("I");
            else if (reminder == 0) sb.append("O");
            else sb.append(s.charAt(reminder - 10));
            a /= 16;
        }
        return sb.reverse().toString();
    }
}
