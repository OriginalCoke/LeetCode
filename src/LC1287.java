public class LC1287 {
    //Element Appearing More Than 25% In Sorted Array
    //ascending, traversal
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n < 4) return arr[0];
        int count = n / 4 + 1;
        int c = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                c++;
                if (c == count) return arr[i];
            } else c = 1;
        }
        return -1;
    }
}
