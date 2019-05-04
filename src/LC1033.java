import java.util.Arrays;

public class LC1033 {
    //Moving Stones Until Consecutive
    //如果相邻, 则不用移动, 其余移动到相邻位置, 即 a 移动到 b-1, c 移动到 b+1
    public int[] numMovesStones(int a, int b, int c) {
        int[] A = {a, b, c};
        Arrays.sort(A);
        a = A[0];
        b = A[1];
        c = A[2];
        int min = 0, max = 0;
        if (a != b - 1) {
            min++;
            max += b - 1 - a;
        }
        if (c != b + 1) {
            min++;
            max += c - b - 1;
        }
        if (b - a == 2 || c - b == 2) min = 1;
        return new int[]{min, max};
    }
}
