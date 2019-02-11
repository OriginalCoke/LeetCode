public class LC242 {
    //Valid Anagram
    //Easy
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
            bucket[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) return false;
        }
        return true;
    }
    //TC: max(26, N) (N for the length of String)
}
