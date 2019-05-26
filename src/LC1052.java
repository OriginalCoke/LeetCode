public class LC1052 {
    //Grumpy Bookstore Owner
    //先计算没有 X 时候的和, 然后对 X 进行移窗, 每次去掉首部, 加上尾部, 判断最大值
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        int diff = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) diff += customers[i];
        }
        int curr = diff;
        for (int i = X; i < n; i++) {
            if (grumpy[i - X] == 1) curr -= customers[i - X];
            if (grumpy[i] == 1) curr += customers[i];
            diff = Math.max(curr, diff);
        }
        int res = sum + diff;
        return res;
    }
}
