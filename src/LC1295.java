public class LC1295 {
    //Find Numbers with Even Number of Digits
    //count the digits
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            String s = "" + num;
            if (s.length() % 2 == 0) res++;
        }
        return res;
    }
}
