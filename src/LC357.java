public class LC357 {
    //Count Numbers with Unique Digits
    //DP
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;//only 0

        int res = 10, i = 9, j = 9;
        while (n > 1 && j > 0) {
            i *= j;
            j--;
            res += i;
            n--;
        }
        return res;
    }
}
