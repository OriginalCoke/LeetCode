public class LC1446 {
    //Consecutive Characters
    //substring 只包含 1 个, 最长重复子串
    public int maxPower(String s) {
        char[] A = s.toCharArray();
        int n = A.length;
        char c = A[0];
        int count = 1, res = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] == c) {
                count++;
            } else {
                res = Math.max(count, res);
                c = A[i];
                count = 1;
            }
        }
        return Math.max(count, res);
    }
}
