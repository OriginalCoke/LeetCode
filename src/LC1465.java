import java.util.Arrays;

public class LC1465 {
    //1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        int hL = horizontalCuts.length, vL = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hMax = Math.max(horizontalCuts[0], h - horizontalCuts[hL - 1]);
        int vMax = Math.max(verticalCuts[0], w - verticalCuts[vL - 1]);
        for (int i = 1; i < hL; i++) hMax = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], hMax);
        for (int i = 1; i < vL; i++) vMax = Math.max(verticalCuts[i] - verticalCuts[i - 1], vMax);
        int res = (int) (((long) vMax * (long) hMax) % mod);
        return res;
    }
}
