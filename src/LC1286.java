public class LC1286 {
    //Iterator for Combination
    //双指针扫描排序过的字符串数组
    class CombinationIterator {
        int[] pointers;
        char[] A;
        int m, n;

        public CombinationIterator(String characters, int combinationLength) {
            A = characters.toCharArray();
            m = A.length;
            n = combinationLength;
            pointers = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == n - 1) pointers[i] = n - 2;
                else pointers[i] = i;
            }
        }

        public String next() {
            int index = -1;
            int temp = m - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (pointers[i] != temp) {
                    index = i;
                    break;
                }
                temp--;
            }
            for (int i = index; i < n; i++) {
                if (i == index) pointers[i]++;
                else pointers[i] = pointers[index] + i - index;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(A[pointers[i]]);
            }
            return sb.toString();
        }

        public boolean hasNext() {
            return pointers[0] != m - n;
        }
    }
}
