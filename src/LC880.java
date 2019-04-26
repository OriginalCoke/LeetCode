public class LC880 {
    //Decoded String at Index
    //字符串以字符开头, 直接计数会 MLE 或者 TLE, 减少 K 的数量, 依次判断是否到达字符串的游标
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long size = 0;
        //S = "leet2code3", K = 10  out: "o"
        for (int i = 0; i < n; i++)
            if (Character.isDigit(S.charAt(i))) size *= (S.charAt(i) - '0');
            else size++;
        //size = 36
        for (int i = n - 1; i >= 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                size /= (S.charAt(i) - '0');
                continue;
            }

            if (K > size)
                K = (int) (K % size);
            if (K == size || K == 0)
                return String.valueOf(S.charAt(i));
            size--;
        }
        return null;
    }
}
