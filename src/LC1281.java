public class LC1281 {
    //Subtract the Product and Sum of Digits of an Integer
    //straight forward
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int v = n % 10;
            product *= v;
            sum += v;
            n /= 10;
        }
        return product - sum;
    }
}
