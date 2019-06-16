import java.util.Arrays;

public class LC1085 {
    //Sum of Digits in the Minimum Number
    //返还最小值的数字和的奇偶性
    public int sumOfDigits(int[] A) {
        Arrays.sort(A);
        int a = A[0], sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        if (sum % 2 == 0) return 1;
        else return 0;
    }
}
