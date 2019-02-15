public class LC223 {
    //Rectangle Area
    //计算overlap的面积,S_A + S_B - S_overLap
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.min(C, G), x2 = Math.max(A, E);
        int y1 = Math.min(D, H), y2 = Math.max(B, F);
        int overLap = 0;
        if (!isRectangleOverlap(x1, x2, y1, y2)) overLap = 0;
        else overLap = Math.abs(x1 - x2) * Math.abs(y1 - y2);
        return Math.abs(C - A) * Math.abs(D - B) + Math.abs(H - F) * Math.abs(G - E) - overLap;
    }

    public boolean isRectangleOverlap(int x1, int x2, int y1, int y2) {
        return (x1 > x2 && y1 > y2);
    }
}
