public class LC1165 {
    //Single-Row Keyboard
    //bucket
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0) res += keyboard.indexOf(word.charAt(0));
            else {
                res += Math.abs(keyboard.indexOf(word.charAt(i)) - keyboard.indexOf(word.charAt(i - 1)));
            }
        }
        return res;
    }
}
