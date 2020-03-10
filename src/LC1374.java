public class LC1374 {
    //Generate a String With Characters That Have Odd Counts
    //生成 n 位的字符串, 每个字符出现的次数是偶数
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }
        if (n % 2 == 0) sb.append('b');
        else sb.append('a');

        return sb.toString();
    }
}
