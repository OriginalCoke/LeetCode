import java.util.Deque;
import java.util.LinkedList;

public class LC1427 {
    //1427. Perform String Shifts
    public String stringShift(String s, int[][] shift) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.addLast(c);
        for (int[] move : shift) {
            int steps = move[1];
            if (move[0] == 0) {
                for (int i = 0; i < steps; i++) {
                    char temp = queue.pollFirst();
                    queue.addLast(temp);
                }
            } else {
                for (int i = 0; i < steps; i++) {
                    char temp = queue.pollLast();
                    queue.addFirst(temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) sb.append(queue.pollFirst());
        return sb.toString();
    }
}
