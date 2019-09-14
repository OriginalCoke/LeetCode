public class LC1170 {
    //Compare Strings by Frequency of the Smallest Character
    //O(m*n)?
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = queries.length, n = words.length;
        int[] q = new int[m];
        int[] w = new int[n];
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = func(queries[i]);
        }
        for (int i = 0; i < n; i++) {
            w[i] = func(words[i]);
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            int v = q[i];
            for (int j = 0; j < n; j++) {
                if (w[j] > v) count++;
            }
            res[i] = count;
        }
        return res;
    }

    public int func(String s) {
        int[] bucket = new int[26];
        char a = 'z';
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
            if (c < a) {
                a = c;
            }
        }
        return bucket[a - 'a'];
    }
}
