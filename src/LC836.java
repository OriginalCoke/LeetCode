public class LC836 {
    //Rectangle Overlap
    //比较两个对角线的投影位置相交条件,如果 x 的同一端投影 > 另一端,同理于y,则相交
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
