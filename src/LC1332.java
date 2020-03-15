public class LC1332 {
    //Remove Palindromic Subsequences
    //2 operations maximum
    public int removePalindromeSub(String s) {
        if (s.length() < 1) return 0;
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) return 1;
        return 2;
    }
}
