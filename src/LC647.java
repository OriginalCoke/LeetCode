public class LC647 {
    //Palindromic Substrings
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendFromMid(s, i, i);
            extendFromMid(s, i, i + 1);
        }
        return count;
    }

    public void extendFromMid(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
    //TC: N^2
}
