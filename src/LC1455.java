public class LC1455 {
    //1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] A = sentence.split(" ");
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }
}
