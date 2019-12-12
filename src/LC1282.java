import java.util.*;

public class LC1282 {
    //Group the People Given the Group Size They Belong To
    //greedy
    //TC: O(n)
    public static void main(String[] args) {
        int[] A = {3, 3, 3, 3, 3, 1, 3};
        groupThePeople(A);
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            if (map.containsKey(k)) {
                temp = map.get(k);
            }
            temp.add(i);
            map.put(k, temp);
        }
        for (int k : map.keySet()) {
            List<Integer> temp = map.get(k);
            List<Integer> list = new ArrayList<>();
            int index = 0;
            while (index < temp.size()) {
                list.add(temp.get(index));
                index++;
                if (index % k == 0) {
                    List<Integer> sub = new ArrayList<>(list);
                    res.add(sub);
                    list.clear();
                }
            }
        }
        return res;
    }
}
