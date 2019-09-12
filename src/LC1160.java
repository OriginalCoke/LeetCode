public class LC1160 {
    //Find Words That Can Be Formed by Characters
    //bucket
    public int countCharacters(String[] words, String chars) {
        int[] bucket = new int[26];
        int res = 0;
        for (char c : chars.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (String s : words) {
            int[] temp = new int[26];
            boolean f = true;
            for (char c : s.toCharArray()) temp[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (temp[i] > bucket[i]) {
                    f = false;
                    break;
                }
            }
            if (f) res += s.length();
        }
        return res;
    }
}
