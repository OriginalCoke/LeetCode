public class LC5 {
    //Longest Palindromic Substring
    //Amazon
    //遍历s,从每一点出发向两边延伸,分2种情况:
    //1.奇数: aba; 2.偶数: abba   设置全局变量进行比较,起点,长度
    int lo, maxLen;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    public void extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
}
