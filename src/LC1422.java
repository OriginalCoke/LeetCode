public class LC1422 {
    //1422. Maximum Score After Splitting a String
    public int maxScore(String s) {
        char[] A = s.toCharArray();
        int countZero = 0, countOne = 0, res = 0;
        for (int c : A) {
            if (c == '1') countOne++;
        }
        for (int i = 0; i < A.length - 1; i++) {
            char c = A[i];
            if (c == '0') {
                countZero++;
            } else countOne--;
            int sum = countZero + countOne;
            res = Math.max(res, sum);
        }
        return res;
    }
}
