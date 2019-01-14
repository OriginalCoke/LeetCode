import java.util.TreeMap;

public class LC975 {
    //Odd Even Jump
    //Solution 1 : Brute Force
    public int oddEvenJumps1(int[] A) {
        int n = A.length, count = 1;
        boolean[] odd = new boolean[n], even = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int step = 0, index = i;
            while (index != -1) {
                step++;
                if (step % 2 == 1) {
                    index = findMin(index, A);
                } else {
                    index = findMax(index, A);
                }
                if (index == n - 1) {
                    count++;
                    System.out.println(i);
                    break;
                }
            }
        }
        return count;
    }

    int findMin(int index, int[] A) {
        int res = 0, min = Integer.MAX_VALUE, a = A[index];
        for (int i = index + 1; i < A.length; i++) {
            if (A[i] >= a && A[i] < min) {
                res = i;
                min = Math.min(min, A[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : res;
    }

    int findMax(int index, int[] A) {
        int res = 0, max = Integer.MIN_VALUE, a = A[index];
        for (int i = index + 1; i < A.length; i++) {
            if (A[i] <= a && A[i] > max) {
                res = i;
                max = Math.max(max, A[i]);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : res;
    }

    //Solution 2 : TreeMap
    public int oddEvenJumps2(int[] A) {
        int n = A.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Integer hi = map.ceilingKey(A[i]), lo = map.floorKey(A[i]);
            if (hi != null) higher[i] = lower[map.get(hi)];
            if (lo != null) lower[i] = higher[map.get(lo)];
            if (higher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }
}
