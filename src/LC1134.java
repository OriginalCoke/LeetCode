public class LC1134 {
    //Armstrong Number
    //brute force
    public boolean isArmstrong(int N) {
        String s = "";
        int copy = N;
        int len = (s + N).length();
        int sum = 0;
        while (N > 0) {
            int r = N % 10;
            sum += Math.pow(r, len);
            N /= 10;
        }
        return sum == copy;
    }
}
