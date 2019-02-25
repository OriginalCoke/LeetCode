public class LC509 {
    //Fibonacci Number
    public int fib(int N) {
        int res = 1, i = 2, prev = 0;
        if (N == 0) return 0;
        if (N == 1) return 1;
        while (i <= N) {
            int temp = res;
            res += prev;
            prev = temp;
            i++;
        }
        return res;
    }
}
