import java.util.HashMap;
import java.util.Map;

public class LC992 {
    //Subarrays with K Different Integers
    public int subarraysWithKDistinct(int[] nums, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        int first = 0;
        int second = 0;
        int count = 0;

        while (second < nums.length) {
            map.put(nums[second], map.getOrDefault(nums[second], 0) + 1);
            if (map.size() > K) {
                map.clear();
                first++;
                second = first;
                continue;
            }
            if (map.size() == K) {
                count++;
                second++;
                if (second == nums.length) {
                    map.clear();
                    first++;
                    second = first;
                }
                continue;
            }
            second++;
        }
        return count;
    }
}
