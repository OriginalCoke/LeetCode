public class LC984 {
    //String Without AAA or BBB
    public String strWithout3a3b(int A, int B) {
        if (A >= B) return helper(A, B);
        else {
            String temp = helper(B, A);
            return temp.replace('a', 'c').replace('b', 'a').replace('c', 'b');
        }
    }

    public String helper(int A, int B) {
        String res = "";
        int rest = A - B;
        if (rest <= B) {
            for (int i = 0; i < rest; i++) res += "aab";
            int left = B - rest;
            for (int i = 0; i < left; i++) res += "ab";
        } else {
            for (int i = 0; i < B; i++) res += "aab";
            int left = rest - B;
            for (int i = 0; i < left; i++) res += "a";
        }
        return res;
    }
}