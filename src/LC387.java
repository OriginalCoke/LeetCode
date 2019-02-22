public class LC387 {
    //First Unique Character in a String
    //Amazon
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        int res = -1;
        for (char c : s.toCharArray()) bucket[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (bucket[curr - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
