import java.util.*;

public class LC981 {
    //Time Based Key-Value Store
    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            TreeMap<Integer, String> temp = map.get(key);
            Integer t = temp.floorKey(timestamp);
            return t == null ? "" : temp.get(t);
        }
    }
}
