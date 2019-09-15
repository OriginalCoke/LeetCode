public class LC1189 {
    //Maximum Number of Balloons
    //bucket
    public int maxNumberOfBalloons(String text) {
        int[] bucket = new int[26];
        for (char c : text.toCharArray()) {
            bucket[c - 'a']++;
        }
        int v1 = Math.min(bucket['l' - 'a'], bucket['o' - 'a']);
        int v2 = Math.min(bucket['b' - 'a'], Math.min(bucket['a' - 'a'], bucket['n' - 'a']));
        return Math.min(v2, v1 / 2);
    }
}
