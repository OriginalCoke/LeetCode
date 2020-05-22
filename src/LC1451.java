import java.util.Arrays;
import java.util.Comparator;

public class LC1451 {
    //1451. Rearrange Words in a Sentence
    public String arrangeWords(String text) {
        String[] A = text.toLowerCase().split(" ");
        Arrays.sort(A, Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder();
        String first = A[0];
        sb.append((char) (first.charAt(0) - 'a' + 'A'));
        sb.append(first.substring(1));
        for (int i = 1; i < A.length; i++) {
            sb.append(" ");
            sb.append(A[i]);
        }
        return sb.toString();
    }
}
