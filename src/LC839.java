public class LC839 {
    //Similar String Groups
    //Google
    int n;

    public int numSimilarGroups(String[] A) {
        n = A.length;
        int res = 0;
        if (n < 2) return n;
        for (int i = 0; i < n; i++) {
            if (A[i] != null) {
                String s = A[i];
                A[i] = null;
                res++;
                dfs(A, s);
            }
        }
        return res;
    }

    public void dfs(String[] A, String a) {
        for (int i = 0; i < n; i++) {
            if (A[i] != null) {
                if (isSimilar(A[i], a)) {
                    String temp = A[i];
                    A[i] = null;
                    dfs(A, temp);
                }
            }
        }
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 2) return false;
        }
        return count == 2 || count == 0;
    }
    //TC: O(N)
}
