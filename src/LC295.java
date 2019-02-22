import java.util.*;

public class LC295 {
    //Find Median from Data Stream
    //Amazon
    //用最大堆和最小堆分别存放一半的数,只关注节点的数,最大堆根节点是较小一半的最大数, 最小堆根节点是较大一半的最小数
    //比较两个堆的大小判断是偶数还是奇数, 求解中数
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        }

        public void addNum(int num) {
            //取出max 的最大值给 min 去排序,最终 max 存放较小的一半,min 存放较大一半
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            else return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
