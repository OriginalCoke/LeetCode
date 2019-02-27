public class LC42 {
    //Trapping Rain Water
    //Amazon
    //从左到右走一遍, 从右到左走一遍, 记录最大值, 两者总和面积 = 总共矩形面积 + 柱形总面积 + 积水面积
    public int trap(int[] height) {
        int area1 = 0, area2 = 0, max1 = 0, max2 = 0, max = 0, sum = 0;
        for (int h : height) {
            if (h > max1) max1 = h;
            max = Math.max(max, h);
            area1 += max1;
            sum += h;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            int h = height[i];
            if (h > max2) max2 = h;
            area2 += max2;
        }
        int res = area1 + area2 - sum - max * height.length;
        return res;
    }
}
