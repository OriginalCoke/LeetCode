import java.util.*;

public class LC380 {
    //Insert Delete GetRandom O(1)
    //之后会修改,先用 list 去实现以下
    class RandomizedSet {
        List<Integer> list;

        public RandomizedSet() {
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (list.contains(val)) return false;
            else {
                list.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!list.contains(val)) return false;
            else {
                return list.remove((Integer) val);
            }
        }

        public int getRandom() {
            int n = list.size();
            return list.get(new Random().nextInt(n));
        }
    }
}
