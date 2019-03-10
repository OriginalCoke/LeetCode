public class LC1006 {
    //Clumsy Factorial
    //对次数统计进行循环
    public int clumsy(int n) {
        if (n == 1) return 1;
        int count = 1, sum = 0, temp = 0;
        while (n > 1) {
            int index = count % 4;
            if (index == 1) {
                if (index == count) {
                    temp = n * (n - 1);
                } else temp = -n * (n - 1);
            } else if (index == 2) {
                temp /= (n - 1);
                sum += temp;
                temp = 0;
            } else if (index == 3) {
                sum += (n - 1);
            }
            count++;
            n--;
        }
        if (count % 4 == 1) sum--;
        return sum + temp;
    }
}
