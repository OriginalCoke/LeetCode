import java.util.*;

public class LC362 {
    //Design Hit Counter
    //Amazon
    //每次击打计算前300秒内的次数, 用 bucket 去存放时间戳, 用取余去覆盖之前超过300秒的时间, 如果时间一样就更新++, 不一样就覆盖
    class HitCounter {
        private int[] times;
        private int[] hits;

        public HitCounter() {
            times = new int[300];
            hits = new int[300];
        }

        public void hit(int timestamp) {
            int index = timestamp % 300;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int total = 0;
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) {
                    total += hits[i];
                }
            }
            return total;
        }
    }
}
