public class LC1456 {
    //1456. Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels(String s, int k) {
        char[] A = s.toCharArray();
        int n = A.length;
        boolean[] mark = new boolean[n];
        int count = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char current = A[i];
            if (i < k) {
                if (isVowel(current)) {
                    mark[i] = true;
                    count++;
                    max = count;
                }
            } else {
                if (mark[i - k]) count--;
                if (isVowel(current)) {
                    mark[i] = true;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
