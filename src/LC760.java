import java.util.HashMap;
import java.util.Map;

public class LC760 {
    //Find Anagram Mappings
    //Easy
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) map.put(B[i], i);
        for (int i = 0; i < A.length; i++) A[i] = map.get(A[i]);
        return A;
        //TC: O(N)  SC: O(N)
    }
}
