public class LC1385 {
    //Find the Distance Value Between Two Arrays
    //应该是考察二分
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int a1 : arr1) {
            boolean f = true;
            for (int a2 : arr2) {
                if (Math.abs(a1 - a2) <= d) {
                    f = false;
                    break;
                }
            }
            if (f) res++;
        }
        return res;
    }
}
